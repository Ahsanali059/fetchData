package com.example.App.resource.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Api.DaoLayer.DatabaseConnection;
import com.example.Api.DaoLayer.databaseConfig;
import com.example.App.Models.abstractModel;
import com.example.App.base.CoreFramework;

public class abstractResourceModel extends CoreFramework
{
	private static final long serialVersionUID = 1L;

	public abstractModel abstractModel;
	
	public PreparedStatement prepareStatement;
	
	
	
	//public static String myTable = null;
	//public String indexColumn;
	
	public databaseConfig databaseConfig;
	
	public DatabaseConnection databaseConnection;
	
	public String tableName =  databaseConfig.TableName;
	
	public String sqlQuery = "";
	
	
	
	public abstractResourceModel() 
	{
		super();
		this.databaseConnection = new DatabaseConnection();
		//this.abstractModel = new abstractModel();
	}

	public ResultSet findAll() throws SQLException {
	    ResultSet resultSet = null;
	    
	    try {
	        this.selectQuery();
	        
	        Connection connection = this.databaseConnection.getConnection();
	        
	        if (connection == null) {
	            throw new SQLException("Database connection is not initialized.");
	        }

	        this.prepareStatement = connection.prepareStatement(sqlQuery);
	        resultSet = prepareStatement.executeQuery();
	        
	    } catch (SQLException e) 
	    {
	        e.printStackTrace();
	        throw e;
	    } finally 
	    {
//	        if (prepareStatement != null) {
//	            prepareStatement.close();
//	        }
	    }

	    return resultSet;
	}



	private abstractResourceModel selectQuery() 
	{
		this.sqlQuery = "SELECT *";
		
//		this.addFieldToSelect("*");
		
		this.sqlQuery = sqlQuery + "FROM " + databaseConfig.TableName;
		
		this.sqlQuery = this.sqlQuery + ";";
		
		return this;
	}
	
//	public void Instantiate(String myTable,String indexColumn)
//	{
//		
//		this.indexColumn = indexColumn;
//		this.myTable=myTable;
//		
//		this.databaseConnection.setMyTableName(this.myTable);
//		
//		this.databaseConnection.setIndexColumn(this.indexColumn);
//		
//		this.SetTableName(this.databaseConnection.getMyTableName());
//	
//	}

//	private void SetTableName(Object myTableName) 
//	{
//		//
//		
//	}

	

}
