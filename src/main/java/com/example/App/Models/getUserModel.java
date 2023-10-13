package com.example.App.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.App.Apiinterface.UserInterface;
import com.example.App.resource.model.abstractResourceModel;
import com.example.App.resource.model.getUserResourceModel;


public class getUserModel extends getUserResourceModel implements UserInterface
{
	private static final long serialVersionUID = 1L;
	
	public abstractResourceModel abstractResourceModel;
	

	public ResultSet rs;
	
	public getUserModel() 
	{
		super();
		this.abstractResourceModel = new abstractResourceModel();
	}


        
	public List<Map<String, String>> getAllUsers() throws SQLException 
	{
		System.out.println("1");
		
		ResultSet rs = abstractResourceModel.findAll();
		
		
		System.out.println("2");
		
		List<Map<String, String>> usersList = new ArrayList<Map<String,String>>();
		
		
		while(rs.next())
		{
			System.out.println("3");
			
			Map<String, String> user = new HashMap<String, String>();
			user.put(UserInterface.ADMIN_table_USER_ID, rs.getString(1));
			user.put(UserInterface.ADMIN_FISRTNAME, rs.getString(2));
			user.put(UserInterface.ADMIN_LASTNAME, rs.getString(3));
			user.put(UserInterface.ADMIN_EMAIL,rs.getString(4));
			
			user.put(UserInterface.ADMIN_PHONE, rs.getString(5));
			
			user.put(UserInterface.ADMIN_USERNAME, rs.getString(6));
			
			System.out.println("4");
			
			usersList.add(user);
			//System.out.println("Value added in map");
		}
		
		System.out.println("5");;
		
		if(rs!=null)
		{
			rs.close();
		}
		
		return usersList;
		
	}
	

}
