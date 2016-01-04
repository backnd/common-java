package com.local.lib.querycrypt.beans;

import java.io.Serializable;
import java.util.HashMap;

import javax.crypto.SecretKey;

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

public class QueryCryptUser implements java.io.Serializable
{
	private String sessionID = "";
	private HashMap md5Keys = new HashMap();
	private SecretKey secretKey = null; 
	/**
	 * @return Returns the md5Keys.
	 */
	public HashMap getMd5Keys()
	{
		return md5Keys;
	}
	/**
	 * @param md5Keys The md5Keys to set.
	 */
	public void setMd5Keys(HashMap md5Keys)
	{
		this.md5Keys = md5Keys;
	}
	/**
	 * @return Returns the sessionID.
	 */
	public String getSessionID()
	{
		return sessionID;
	}
	/**
	 * @param sessionID The sessionID to set.
	 */
	public void setSessionID(String sessionID)
	{
		this.sessionID = sessionID;
	}
	
	public void addToMD5Map(String md5, byte[] encryptedStr)
	{
		this.md5Keys.put(md5, encryptedStr);
	}
	
	public byte[] getByKey(String md5key)
	{
		return (byte[]) this.md5Keys.get(md5key);
	}
	/**
	 * @return Returns the secretKey.
	 */
	public SecretKey getSecretKey()
	{
		return secretKey;
	}
	/**
	 * @param secretKey The secretKey to set.
	 */
	public void setSecretKey(SecretKey secretKey)
	{
		this.secretKey = secretKey;
	}
	
	public QueryCryptUser(String sessionid, SecretKey key)
	{
		super();
		// TODO Auto-generated constructor stub
		secretKey = key;
		sessionID = sessionid;
	}
	
	
}
