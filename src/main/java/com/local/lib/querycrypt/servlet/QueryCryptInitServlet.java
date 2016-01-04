package com.local.lib.querycrypt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.guhesan.querycrypt.QueryCrypt;
import com.guhesan.querycrypt.beans.QueryCryptProperties;

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

public class QueryCryptInitServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ServletContext application = null;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException
	{		
		super.init();		
		QueryCryptProperties qcp = new QueryCryptProperties();
		application = this.getServletContext();
		
		if (getInitParameter("debug") != null)
		{
			try
			{
				qcp.setDebug(new Boolean(getInitParameter("debug")).booleanValue());
			} catch (Exception e)
			{				
				e.printStackTrace();
			}			
		}
		
		if (getInitParameter("queryName") != null)
		{
			try
			{
				qcp.setQueryName((String) getInitParameter("queryName"));
				application.setAttribute("queryCryptParameterName", (String) getInitParameter("queryName"));
			} catch (Exception e)
			{				
				e.printStackTrace();
			}			
		}
		
		//Initialize the QueryCrypt Engine
		QueryCrypt.init(qcp);		
	}
	
}
