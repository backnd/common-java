package com.guhesan.querycrypt.util;

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

public class HexConvert
{
	private HexConvert()
	{
		//To prevent folks from instantiating
	}
	
	public static final String encode(byte[] convertBytes)
	{
		StringBuffer sb = new StringBuffer();
		Byte by;
		int k;
		int lowfour, highfour;
		try
		{
			for (int i=0; i<convertBytes.length; i++)
			{
				by = new Byte(convertBytes[i]);
				k = by.intValue();
				lowfour = k & 0X0000000F ; //get the low four bytes
				highfour = k & 0X000000F0 ; //get the high four bytes
				highfour = highfour>>>4 ;//shift those four bits right
				sb.append(Integer.toHexString(highfour));
				sb.append(Integer.toHexString(lowfour));
			}
		}catch(Exception e)
		{
			sb = new StringBuffer();
		}
		return new String(sb);
	}
	
	public static final byte[] decode(String encodedString)
	{
		byte[] b = new byte[(encodedString.length()/2)];		
		int k;
		int lowfour, highfour;
		char c, cnext;
		try
		{
			int iter = (encodedString.length())/2;
			int thisCnt;
			for (int i=0; i<iter; i++)
			{
				thisCnt = i*2;
				c = encodedString.charAt(thisCnt);
				cnext = encodedString.charAt(thisCnt+1);
				highfour = Character.digit(c,16);
				lowfour  = Character.digit(cnext,16);
				highfour = highfour<<4;
				k = highfour ^ lowfour ; //XOR both to get result
				
				b[i] = (byte) (new Integer(k)).byteValue();
			}
		}catch(Exception e)
		{
			return null;
		}
		return b;
	}
	
}

