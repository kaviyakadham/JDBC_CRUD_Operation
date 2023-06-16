package com.jdbc.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateApp {

	@SuppressWarnings("resource")
	public static void updateApp() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement stmnt=null;
		
		Scanner scanner=new Scanner(System.in);
		try {
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null)
			{
				System.out.println("Enter the empId to update the details");
				int EmpId=scanner.nextInt();
				System.out.println("enter 1 to update name:\n enter 2 to update Age:\n enter 3 to update dept:");
				int updateNo=scanner.nextInt();
				if(updateNo==1)
				{
					System.out.println("enter the name:");
					String EmpName=scanner.next();
					String updateQuery="update employee set EmpName=? where EmpId=?";
					stmnt=connection.prepareStatement(updateQuery);
					stmnt.setString(1, EmpName);
					stmnt.setInt(2, EmpId);
				
				}
				
				if(updateNo==2)
				{
					System.out.println("enter the age:");
					int EmpAge=scanner.nextInt();
				    String updateQuery="update employee set EmpAge=? where EmpId=?";
				    stmnt=connection.prepareStatement(updateQuery);
				    stmnt.setInt(1, EmpAge);
				    stmnt.setInt(2, EmpId);
				}
				if(updateNo==3)
				{
					System.out.println("enter the Dept:");
					String EmpDept=scanner.next();
					String updateQuery="update employee set EmpDept=? where EmpId=?";
					stmnt=connection.prepareStatement(updateQuery);
					stmnt.setString(1, EmpDept);
					stmnt.setInt(2, EmpId);
				
				}
				
				
				int no=stmnt.executeUpdate();
				System.out.println("no of rows updated:"+no);
				
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
			if(stmnt!=null)
				stmnt.close();
			if(connection!=null)
				connection.close();
			if(scanner!=null)
				scanner.close();
		}

	}

}
