package com.jdbc.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseConnection {
	public static void closeConnection(ResultSet resultSet,PreparedStatement statement,Connection connection) throws SQLException
	{
		if(resultSet!=null)
		{
			resultSet.close();
		}
		if(statement!=null)
		{
			statement.close();
		}
		if(connection!=null)
		{
			connection.close();
		}
	}

}
