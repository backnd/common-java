package com.local.lib.querycrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import com.guhesan.querycrypt.beans.QueryCryptProperties;
import com.guhesan.querycrypt.beans.*;
import com.guhesan.querycrypt.util.*;



/**
 * @author Venkatt Guhesan (www.AvedaTech.com)
 * This code is part of the QueryCrypt project: 
 * All Rights Reserved.
 * 
 * THE QUERYCRYPT SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AVEDATECH COMPANY 
 * OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF 
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED 
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THE QUERYCRYPT SOFTWARE, EVEN IF ADVISED OF 
 * THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Saturday, September 24, 2005
 */
public final class QueryCrypt
{
	private static String algorithm = "DESede";
	private static final QueryCrypt instance = new QueryCrypt();
	private static HashMap userSessionMap = new HashMap();	
	private static QueryCryptProperties initQCP = null;
	//private static HashMap queryMap = new HashMap();

	private QueryCrypt()
	{
		//To prevent users from constructing this class		
	}

	public static QueryCrypt getInstance()
	{
		return instance;		
	}

	public static void init(QueryCryptProperties qcp)
	{
		initQCP = qcp;
		if (initQCP.isDebugEnabled())
		{
			System.out.println("Successfully initialized QueryCrypt by Aveda Technology, Inc.");
		}
	}

	public static String encrypt(HttpServletRequest request, String message)
	{
		if (initQCP.isDebugEnabled())
		{
			System.out.println("======== BEGIN ENCRYPTION ===============");
			System.out.println("encrypt() : Plain String : " + message);
		}
		String encodedOutput = "";		

		String sessionID = request.getSession().getId();
		SecretKey key = null;

		QueryCryptUser qcu = grabUserFromKeyStore(sessionID, request);
		key = qcu.getSecretKey();

		if (key != null)
		{
			encodedOutput = performEncrypt(message, qcu, request);			
		}

		encodedOutput = initQCP.getQueryName() + "=" + encodedOutput;

		if (initQCP.isDebugEnabled())
		{			
			System.out.println("encrypt() : Encrypted String : " + encodedOutput);
			System.out.println("======== END ENCRYPTION ===============");
		}

		return encodedOutput;		
	}

	public static RequestParameterObject decrypt(HttpServletRequest request)
	{
		if (initQCP.isDebugEnabled())
		{
			System.out.println("======== BEGIN DECRYPTION ===============");			
		}

		RequestParameterObject rpo = null;
		String sessionID = request.getSession().getId();

		String encryptedString = "";
		if (request.getParameter(initQCP.getQueryName()) != null){
			encryptedString = (String) request.getParameter(initQCP.getQueryName());
		}
		
		if (initQCP.isDebugEnabled())
		{				
			System.out.println("decrypt() : Encrypted String : " + encryptedString);
		}
		SecretKey key = null;
		QueryCryptUser qcu = grabUserFromKeyStore(sessionID, request);
		key = qcu.getSecretKey();
		if (key != null)
		{
			String decodedResult = performDecrypt(encryptedString, qcu, request);
			rpo = new RequestParameterObject(decodedResult);
		}


		if (initQCP.isDebugEnabled())
		{
			System.out.println("decrypt() : Plain String : " + rpo.toString());
			System.out.println("======== END DECRYPTION ===============");
		}

		return rpo;
	}

	private static String performEncrypt(String input, QueryCryptUser qcu, HttpServletRequest request)
	{		
		String result = "";
		if (initQCP.isDebugEnabled())
		{
			System.out.println("Input - Plain Message:"+ input);
		}

		try
		{
			SecretKey key = qcu.getSecretKey();
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] inputBytes = input.getBytes();
			byte[] outputBytes = cipher.doFinal(inputBytes);   
			if (initQCP.isDebugEnabled())
			{
				System.out.println("Output - Encrypted Message (Before Encoding):"+ outputBytes.toString());
			}
			String md5result = putMD5ToHash(outputBytes, key.getEncoded(), qcu, request);
			if (initQCP.isDebugEnabled())
			{
				System.out.println("Output - MD5 of Encrypted Message:"+ md5result);
			}
			return md5result;
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	private static String performDecrypt(String md5String, QueryCryptUser qcu, HttpServletRequest request)
	{				
		String out = "";

		try
		{
			SecretKey key = qcu.getSecretKey();
			//Fetch the Encrypted String based on MD5 String
			if (initQCP.isDebugEnabled())
			{
				System.out.println("Input - MD5 String:"+ md5String);
			}
			byte[] encryptedString = getMD5ToHash(md5String, qcu, request);
			if (encryptedString != null)
			{
				if (initQCP.isDebugEnabled())
				{				
					System.out.println("Input - Encrypted Message (Before Decode):"+ encryptedString.toString());
				}
				Cipher cipher = Cipher.getInstance(algorithm);
				cipher.init(Cipher.DECRYPT_MODE, key);
				byte[] recoveredBytes = cipher.doFinal(encryptedString);
				String recovered = new String(recoveredBytes);
				if (initQCP.isDebugEnabled())
				{
					System.out.println("Output - Decrypted Message:"+ recovered);
				}
				return recovered;
			}
			else
			{
				return md5String;
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		return out;
	}

	private static QueryCryptUser grabUserFromKeyStore(String sessionID,HttpServletRequest request)
	{		
		QueryCryptUser qcu = null;
		SecretKey b = null;

		//Lets get the session scope
		if (initQCP.isSessionKeyEnabled())
		{

			if (userSessionMap.containsKey(sessionID))
			{
				qcu = (QueryCryptUser) userSessionMap.get(sessionID);				
			}
			else if(request.getSession().getAttribute("userSessionMapArray") != null ){
				qcu = (QueryCryptUser)request.getSession().getAttribute("qcu");
				userSessionMap = (HashMap)request.getSession().getAttribute("userSessionMapArray");
			}
			else
			{
				try
				{
					b = KeyGenerator.getInstance(algorithm).generateKey();
					qcu = new QueryCryptUser(sessionID, b);
					userSessionMap.put(sessionID, qcu);
					
					request.getSession().setAttribute("userSessionMapArray", userSessionMap);
					request.getSession().setAttribute("qcu", qcu);
					
				} catch (Exception e)
				{					
					e.printStackTrace();
				}

			}
			if (initQCP.isDebugEnabled())
			{
				System.out.println("Session ID:" + qcu.getSessionID());
			}
		}		

		return qcu;
	}

	private final static byte[] getMD5ToHash(String md5, QueryCryptUser qcu, HttpServletRequest request)
	{
		if (qcu.getByKey(md5) != null)
		{
			return (byte[]) qcu.getByKey(md5);
		}
		else if(request.getSession().getAttribute("md5KeysHashMapArray") != null){
			qcu.setMd5Keys((HashMap)request.getSession().getAttribute("md5KeysHashMapArray"));
			return (byte[]) qcu.getByKey(md5);
		}
		else
		{
			return null;
		}
	}

	private final static String putMD5ToHash(byte[] encryptedString, byte[] key, QueryCryptUser qcu, HttpServletRequest request)
	{
		//Perform MD5 of the encryptedString
		byte[] md5str = null;
		String md5result = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(encryptedString);
			md5str =  md5.digest(key);
			md5result = HexConvert.encode(md5str);
			qcu.addToMD5Map(md5result, encryptedString); 
			request.getSession().setAttribute("md5KeysHashMapArray", qcu.getMd5Keys());
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.out.println("MD5 Algorithm is not available");
			e.printStackTrace();
		}

		return md5result;		
	}

	public void clearUserInfo(String sessionID)
	{
		userSessionMap.remove(sessionID);
		if (initQCP.isDebugEnabled())
		{
			System.out.println("User Session:" + sessionID + " and all related query string data has been successfully removed.");
		}
	}
}