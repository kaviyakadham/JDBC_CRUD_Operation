package com.jdbc.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getJdbcConnection() throws SQLException
	{
		Connection connection=null;

		String url="jdbc:mysql://localhost:3306/kaviyadb1";
		String user="root";
		String password="3412";
		
		connection=DriverManager.getConnection(url, user, password);
		if(connection!=null)
		{
			return connection;
			
		}
		return connection;
	}

}
