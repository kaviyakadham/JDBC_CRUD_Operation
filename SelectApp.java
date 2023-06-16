package com.jdbc.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectApp {

	public static void selectApp() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement stmnt=null;
		ResultSet resultSet=null;
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the EmpId to get the details:");
		int id=scanner.nextInt();
		
		try
		{
	    connection=JdbcConnection.getJdbcConnection();
	     if(connection!=null)
	     {
	    	String selectQuery="select EmpId,EmpName,EmpAge,EmpDept from employee where EmpId=?";
	    	stmnt=connection.prepareStatement(selectQuery);
	    	
	    	if(stmnt!=null)
	    	{
	    		stmnt.setInt(1,id);
	    		resultSet=stmnt.executeQuery();
	    		if(resultSet!=null)
	    		{
	    			System.out.println("EmpId\tEmpName\tEmpAge\tEmpDept");
	    			while(resultSet.next())
	    			{
	    				int EmpId=resultSet.getInt("EmpId");
	    				String EmpName=resultSet.getString("EmpName");
	    				int EmpAge=resultSet.getInt("EmpAge");
	    				String EmpDept=resultSet.getString("EmpDept");
	    				
	    				System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAge+"\t"+EmpDept);
	    				
	    			}
	    		}
	    	}
	    	
	    	
	    	
	     }
			
		}catch(SQLException se)
		{
		se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			CloseConnection.closeConnection(null, stmnt, connection);
			if(scanner!=null)
				scanner.close();
		}

	}

}
