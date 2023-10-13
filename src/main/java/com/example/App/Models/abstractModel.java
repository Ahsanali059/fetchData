package com.example.App.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.App.resource.model.abstractResourceModel;

public class abstractModel extends abstractResourceModel
{

	private static final long serialVersionUID = 1L;
	
	private ResultSet resultSet;
	
	   
	public ResultSet findAllData() throws SQLException
	{
		this.resultSet = super.findAll();
		return this.resultSet;
	}
}


