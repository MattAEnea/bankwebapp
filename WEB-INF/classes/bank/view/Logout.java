package bank.view;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			req.getRequestDispatcher("link.html").include(req, res);

			HttpSession ses = req.getSession();
			ses.invalidate();

			out.print("You have logged out.");
			out.close();
		}
		catch(ServletException | IOException e)
		{
			System.out.println("Logout failed.");
			e.printStackTrace();
		}
	}
}
