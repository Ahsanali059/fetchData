package com.example.App.abstractServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.App.base.CoreFramework;

public class AbstractHttpServlet extends CoreFramework  
{

	private static final long serialVersionUID = 1L;
	
	
	public HttpSession httpSession;
	
	
	public AbstractHttpServlet() 
	{
		super();
		
	}
	
	public HttpSession createSession(HttpServletRequest request,HttpServletRequest response)
	{
		return this.httpSession = request.getSession(true);
		
	}
	

}
