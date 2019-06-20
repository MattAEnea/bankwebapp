package bank.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLogin extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			req.getRequestDispatcher("link.html").include(req, res);
			out.println("<html>");
			out.println("<head>");
			out.println("<meta content=\"text/html; charset=ISO-8859-1\">");  
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Bank login</h1><hr>");
			out.println("<form method=\"post\" action=\"log\">");
			out.println("<b>Enter your username: </b>");
			out.println("<input type=\"text\" name=\"firstName\"/><br>");
			out.println("<b>Enter your password: </b>");
			out.println("<input type=\"password\" name=\"password\"/><br>");
			out.println("<input type=\"submit\" value=\"Submit\"/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
		catch(ServletException | IOException e)
		{
			System.out.println("Form login failed.");
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		doGet(req, res);
	}


}
