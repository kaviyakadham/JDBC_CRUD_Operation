package com.jdbc.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteApp {

	public static void deleteApp() throws SQLException
	{
		Connection connection=null;
		PreparedStatement stmnt=null;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the EmpId you want to delete:");
		int EmpId=scanner.nextInt();
		try {
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null)
			{
				String deleteQuery="delete from employee where empId=?";
				stmnt=connection.prepareStatement(deleteQuery);
				if(stmnt!=null)
				{
					stmnt.setInt(1,EmpId);
					int noOfRows=stmnt.executeUpdate();
					System.out.println("no of rows deleted:"+noOfRows);
				}
			}
		}
		catch(SQLException se)
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
