package com.jdbc.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertApp {

	public static void insertApp() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement stmnt=null;
		
		Scanner scanner=new Scanner(System.in);

		try
		{
		System.out.println("Enter the EmpId :");
		int EmpId=scanner.nextInt();
		
		System.out.println("enter the name:");
		String EmpName=scanner.next();
		 
		System.out.println("enter the age:");
		int EmpAge=scanner.nextInt();
		 
		System.out.println("Enter the EmpDept: ");
		String EmpDept=scanner.next();
		
		
		String insertQuery="insert into employee(EmpId,EmpName,EmpAge,EmpDept)values(?,?,?,?)";
		
	    connection=JdbcConnection.getJdbcConnection();
	     if(connection!=null)
	     {
	    	
	    	stmnt=connection.prepareStatement(insertQuery);
	    	
	    	if(stmnt!=null)
	    	{
	    		stmnt.setInt(1,EmpId);
	    		stmnt.setString(2, EmpName);
	    		stmnt.setInt(3, EmpAge);
	    		stmnt.setString(4, EmpDept);
	    		
	    		int noOfRows=stmnt.executeUpdate();
	    		System.out.println("no of rows affected is:"+noOfRows);
	    	}
	    	
	    	
	    	
	     }
			
		}catch(SQLException se)
		{
		se.printStackTrace();
		}catch(InputMismatchException ie)
		{
		  System.out.println("please enter a valid input");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			CloseConnection.closeConnection(null, stmnt, connection);
//			if(stmnt!=null)
//				stmnt.close();
//			if(connection!=null)
//				connection.close();
			if(scanner!=null)
				scanner.close();
		}
		

	}

}
