package bank.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCreate extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			req.getRequestDispatcher("static/link.html").include(req, res);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta content=\"text/html; charset=ISO-8859-1\">");  
			out.println("<title>Create Account</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Bank Account Creation</h1><hr>");
			out.println("<form method=\"post\" action=\"acc\">");
			out.println("<b>Enter a username: </b>");
			out.println("<input type=\"text\" name=\"firstName\"/><br>");
			out.println("<b>Enter a password: </b>");
			out.println("<input type=\"password\" name=\"password\"/><br>");
			out.println("<input type=\"submit\" value=\"Submit\"/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
		catch(ServletException | IOException e)
		{
			System.out.println("Form create failed.");
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		doGet(req, res);
	}
}
