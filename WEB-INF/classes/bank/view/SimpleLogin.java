package bank.view;

import bank.beans.Account;
import bank.database.*;
import bank.controller.*;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleLogin extends HttpServlet
{


	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			//Getting the link html for page switching
			System.out.println("Saving details...");
			//req.getRequestDispatcher("link.html").include(req, res);
			Account attempt = new Account();
			//gets the account name and enters into object
			String name = req.getParameter("fullName");
			attempt.setName(name);
			
			StoreAccount acc = new StoreAccount("matt", "2395eam");
			Account account = acc.pullAccount(attempt.getName());
			if (account == null)
			{
				HttpSession session = req.getSession();
				session.setAttribute("AccountSession", attempt);
				res.sendRedirect("FailPage.jsp?User=" + attempt.getName() + 
						"&msg=Account does not exist.");
			}

			//checks password to account pulled from db
			PasswordEncryption pe = new PasswordEncryption();	
			if(pe.checkPass(req.getParameter("password"), account.getPassword(), account.getSalt()))
			{
				HttpSession session = req.getSession();
				session.setAttribute("AccountSession", account);
				res.sendRedirect("LoginPage.jsp?User=" + account.getName() + 
						"&msg=You have logged in to your account");
			}
			else
			{
				HttpSession session = req.getSession();
				session.setAttribute("AccountSession", account);
				res.sendRedirect("FailPage.jsp?User=" + account.getName() + 
						"&msg=You have entered the wrong password. Please try again.");
			}

		}
		catch(IOException e)
		{
			System.out.println("Simple login failed.");
			e.printStackTrace();
		}
	}
}
