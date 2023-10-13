package com.example.App.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.App.Models.getUserModel;
import com.example.App.abstractServlet.AbstractHttpServlet;
import com.example.App.abstractServlet.SuperRouter;

public class getAllUserController extends SuperRouter
{
	private static final long serialVersionUID = 1L;
	
	public getUserModel getUserModel;
	
	public HttpSession session;
	
	public AbstractHttpServlet abstractHttpServlet;
	
	public getAllUserController()
	{
		this.getUserModel = new getUserModel();
		this.abstractHttpServlet = new AbstractHttpServlet();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		session = abstractHttpServlet.createSession(req, req);
		try
		{
			List<Map<String, String>> usersData = this.getUserModel.getAllUsers();
			
			PrintWriter out = resp.getWriter();
		    resp.setContentType("text/html");
		    
		    System.out.println(usersData);
		    
		    session.setAttribute("user_data",usersData);
		    
		    resp.sendRedirect("/com.example.App/index.jsp");
		    
		    
		    
		    
		    out.print("<h4 style=\"color:green\">Successfully fetched the data</h4>");
		    
		    
		}
		catch (Exception e) 
		{
			//System.out.println("somemthing went wrong in controller");
			e.printStackTrace();
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			out.print("<h4 style=\"color:red\">something went wrong in controller</h4>");

			
		}
	}
	
	

}
