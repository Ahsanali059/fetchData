package com.example.App.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext; // Add this import

import com.example.App.Models.getAllCustomerModel;


//in future this class inherit SuperRouter
public class getAllCustomerController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    
    public static ServletContext servletContext;
    
    public getAllCustomerModel getAllCustomerModel;

    public getAllCustomerController() {
        super();
        this.getAllCustomerModel = new getAllCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        
        this.getAllCustomerModel.setSessionManager(this.setSession());

        
        String userId = request.getParameter("user_id"); 

        Map<String, Object> getAllCustomerModelResponse = this.getAllCustomerModel.getCustomer(userId);

        response.setContentType("text/html");

        Boolean error = (Boolean) getAllCustomerModelResponse.get("error");
        String message = (String) getAllCustomerModelResponse.get("message");

        if (error == true) 
        {
        	out.println("<h3 style='color=red'>something went wrong in controller layer</h3>");
            response.sendRedirect("/com.example.App/admin/users/register?key=" + this.sfmsSystemKey.toLowerCase() + "&error=" + error + "&message=" + message);
        } else 
        {
            // Redirect to the profile page 
        }
    }
}
