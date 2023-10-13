package com.example.Api.DaoLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	public Connection databaseConnection;
	
	//public String myTableName;
	
	//public String IndexColumn;
	
	public DatabaseConnection() 
	{
		this.databaseConnection = this.getConnection();
	}

	public Connection getConnection() 
	{
	    if (this.databaseConnection == null) 
	    {
	       
	        try 
	        {
	            this.createDatabaseConnection();
	            
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            
	        }
	    }
	    return databaseConnection;
	}

	
	public static void main(String[] args) {
		
	}

	public void createDatabaseConnection() 
	{
		try 
		{
			if(this.databaseConnection==null)
			{
				String database_driver = databaseConfig.MYSQL_DRIVER;
				String mysql_host = databaseConfig.MYSQL_HOST;
				String mysql_portNo = databaseConfig.PORT_NUMBER;
				String databaseUsername = databaseConfig.USERNAME;
				String dbpassword = databaseConfig.DBPASSWORD;
				String dbName = databaseConfig.DatabaseName;
				
				String server_time_zone = databaseConfig.SERVER_TIME_ZONE;
				
				String databaseURL = "jdbc:mysql://";
				databaseURL = databaseURL + mysql_host;
				
				databaseURL = databaseURL + mysql_portNo;
				databaseURL = databaseURL + "/"+databaseConfig.DatabaseName;
				//databaseURL = databaseURL +"?ServerTimezome = "+server_time_zone;
				
				
				Class.forName(database_driver);
				
				System.out.println("Database Selected");
				
				this.databaseConnection = DriverManager.getConnection(databaseURL,databaseUsername,dbpassword);
				
			    System.out.println("connection Created");
			    
			    
				
			}
		} 
		catch (SQLException | ClassNotFoundException ex) 
		{
		    ex.printStackTrace();
		    
		}
		
	}
	
	public void CloseConnection()throws SQLException
	{
		if(this.databaseConnection!=null)
		{
			databaseConnection.close();
		}
	}
	
	

	
	
	
}
