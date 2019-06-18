package bank.view;

import bank.beans.Account;
import bank.database.*;
import bank.controller.*;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCreate extends HttpServlet
{

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			//res.setContentType("text/html");
			//Getting the link html for page switching
			System.out.println("Saving details...");
			//req.getRequestDispatcher("link.html").include(req, res);
			Account account = new Account();
			//gets the account name and enters into object
			String name = req.getParameter("fullName");
			System.out.println("name: " + name);
			account.setName(name);
			
			//Saves salt and encrypted password into account
			/*PasswordEncryption pe = new PasswordEncryption();
			account.setSalt(pe.getSalt());
			account.setPassword(pe.hashThePass(req.getParameter("password"), account.getSalt()));

			//Stores the account into the database with correct accNum	
			InitDatabase db = new InitDatabase("matt", "2395eam");
			db.createDB();
			db.createAccounts();	
			StoreAccount acc = new StoreAccount("matt", "2395eam");
			*/
			//Redirect to jsp for display
			res.sendRedirect("CreatePage.jsp?User=" + account.getName() + 
					"&msg=Thank you for making an account with ____ Bank");
		}
		catch(IOException e)
		{
			System.out.println("Simple create failed.");
			e.printStackTrace();
		}
	}
}
