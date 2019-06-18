package bank.database;

import bank.beans.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;

public class StoreAccount
{
	private String user;
	private String pass;

	public StoreAccount(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}


	public void insertAccount(Account account)
	{
		try
		{
			//sets db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//sets timezone and connects
			String connString = "jdbc:mysql://localhost/webbank?user=" + user +
				"&password=" + pass + "&useLegacyDateTimeCode=false&" + 
				"serverTimezone=America/New_York";
			Connection conn = DriverManager.getConnection(connString);
			//sql statement
			String stmtString = "INSERT INTO accounts "
					+ "(fullName, username, password, salt)"
					+ "VALUES (?, ?, ?, ?, ?)";
			//prepared statement setup
			PreparedStatement pstmt = conn.prepareStatement(stmtString);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getUsername());
			pstmt.setString(3, account.getPassword());
			pstmt.setString(4, account.getSalt());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("Insert successful.");
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error opening database");
			e.printStackTrace();
		}
	}

	public Account pullAccount(String username)
	{
		try
		{
			//set db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection setup and setting timezone
			String connString = "jdbc:mysql://localhost/webbank?user=" + user +
				"&password=" + pass + "&useLegacyDateTimeCode=false&" + 
				"serverTimezone=America/New_York";
			Connection conn = DriverManager.getConnection(connString);
			//search by accNum
			String stmtString = "SELECT * FROM accounts WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(stmtString);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			Account tempA = new Account();
			//checks if result set is pulled
			if(rs.absolute(1))
			{
				tempA.setName(rs.getString(1));
				tempA.setUsername(rs.getString(2));
				tempA.setPassword(rs.getString(3));
				tempA.setSalt(rs.getString(4));
			}
			else
			{
				System.out.println("No such data");
				rs.close();
				pstmt.close();
				conn.close();
				return null;
			}
			rs.close();
			pstmt.close();
			conn.close();
			return tempA;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error opening database");
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Account> getAccounts()
	{
		try
		{
			//set db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection setup and setting timezone
			String connString = "jdbc:mysql://localhost/webbank?user=" + user +
				"&password=" + pass + "&useLegacyDateTimeCode=false&" + 
				"serverTimezone=America/New_York";
			Connection conn = DriverManager.getConnection(connString);
			//search by accNum
			String stmtString = "SELECT * FROM accounts";
			PreparedStatement pstmt = conn.prepareStatement(stmtString);
			ResultSet rs = pstmt.executeQuery();
			List<Account> aList = new ArrayList<Account>();
			while(rs.next())
			{
				Account tempA = new Account();
				//checks if result set is pulled
				tempA.setName(rs.getString(1));
				tempA.setUsername(rs.getString(2));
				tempA.setPassword(rs.getString(3));
				tempA.setSalt(rs.getString(4));
				aList.add(tempA);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return aList;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error opening database");
			e.printStackTrace();
			return null;
		}
		
	}
}
