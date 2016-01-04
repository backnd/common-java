package com.local.lib.querycrypt.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.guhesan.querycrypt.QueryCrypt;

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

public class QueryCryptSessionListener implements HttpSessionListener
{

	public void sessionDestroyed(HttpSessionEvent sessionEvt)
	{
		//Find out the sessionID
		String sessionID = sessionEvt.getSession().getId();
		QueryCrypt.getInstance().clearUserInfo(sessionID);
	}

	public void sessionCreated(HttpSessionEvent sessionEvt)
	{
		// Do nothing when a session is created		
	}

}
