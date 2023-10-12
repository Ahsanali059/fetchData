package com.example.App.Models;

import java.rmi.server.LoaderHandler;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

public class getAllCustomerModel extends AdminUsersResourceModel implements adminUsersInterface
{
	public static final long SerialVersionUID = 1L;
	
	public ResultSet resultSet;
	
	public ResultSetMetaData resultSetMetaData;
	
	protected Map<String, String> data;
	
	public String tageType;
	
	public Map<String, String> requestParams;
	
	

	public getAllCustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Map<String, Object> getCustomer(String userId) 
	{
		this.methodResponse = this.prepareResponse(false,true,
				AbstractResourceModel.METHOD_RESPONSE_ERROR_TYPE_FAILED,
				"Something went wrong while fetching the Customer..");
		
		
		
		
		try 
		{
			
			
			if(resultSet.next())
			{
				Map<String, String> customerData = new HashMap<String, String>();
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_FIRSTNAME, resultSet.getString(1));
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_LASTNAME, resultSet.getString(2));
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_EMAIL, resultSet.getString(3));
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_ADMIN_PHONE, resultSet.getString(4));
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_USERNAME, resultSet.getString(5));
				customerData.put(adminUsersInterface.TABLE_ADMIN_USER_ADMIN_TYPE, resultSet.getString(14));
				customerData.put("interface_local", resultSet.getString(18));
				
				//store all attributes in Session 
				
				
				
				
			}
			this.methodResponse = this.load(userId);
			
			
            this.methodResponse = this.prepareResponse(true, false, AbstractResourceModel.METHOD_RESPONSE_ERROR_TYPE_NONE, "Customer data retrieved successfully.");
            return customerData;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return this.methodResponse;
	}
	
	

}
