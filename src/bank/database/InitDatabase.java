package bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitDatabase
{
	private String user;
	private String pass;

	public InitDatabase(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}

	//checks if db is made
	public void createDB()
	{
		try
		{
			//db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//sets timezone
			String connString = "jdbc:mysql://localhost?user=" + user +
				"&password=" + pass + "&useLegacyDateTimeCode=false&" + 
				"serverTimezone=America/New_York";
			Connection conn = DriverManager.getConnection(connString);
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS webbank");
			stmt.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error creating database");
			e.printStackTrace();
		}
	}
	//checks for table
	public void createAccounts()
	{
		try
		{
			//sets db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//sets proper timezone
			String connString = "jdbc:mysql://localhost/webbank?user=" + user +
				"&password=" + pass + "&useLegacyDateTimeCode=false&" + 
				"serverTimezone=America/New_York";
			Connection conn = DriverManager.getConnection(connString);
			Statement stmt = conn.createStatement();
			//creates the customer table
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (accNum INT AUTO_INCREMENT, "
					+ "fullName VARCHAR(40), "
					+ "username VARCHAR(24), "
					+ "password VARCHAR(64), "
					+ "salt VARCHAR(64), "
					+ "PRIMARY KEY (accNum))");
			stmt.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error creating table customers");
			e.printStackTrace();
		}
	}
}
