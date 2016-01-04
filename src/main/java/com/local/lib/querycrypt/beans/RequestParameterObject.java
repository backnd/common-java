package com.local.lib.querycrypt.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

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

public class RequestParameterObject
{
	private HashMap hm = new HashMap();
	private String fullInitString = "";
		
	public RequestParameterObject(String initString)
	{
		fullInitString = initString;
		StringTokenizer st = new StringTokenizer(initString, "&");
		while(st.hasMoreElements())
		{
			String element = st.nextToken();
			try
			{
				String name = element.substring(0,element.indexOf('='));
				String value = element.substring(element.indexOf('=')+1, element.length());
				hm.put(name, value);
			}catch (Exception e)
			{
				System.out.println("Element:" + element + " was not in the format name=value or name=value1,value2,value3.");
			}
		}
	}
	
	
	public java.util.Map getParameterMap()
	{
		return (java.util.Map) hm;
	}
	
	public java.lang.String getParameter(java.lang.String name)
	{				
		return (String) hm.get(name);
	}
	
	public java.util.Enumeration getParameterNames()
	{
		return (java.util.Enumeration) hm.keySet();
	}
	
	public java.lang.String[] getParameterValues(java.lang.String name)
	{
		java.util.ArrayList al = new ArrayList();		
		StringTokenizer st = new StringTokenizer((String) hm.get(name) , ",");		
	    while (st.hasMoreTokens()) 
	    {
	    	al.add((String) st.nextElement());
	    }
	    
	    return (String[]) (al.toArray((String[]) new String[1]));
	}
	
	public String toString()
	{
		return fullInitString;
	}
}
