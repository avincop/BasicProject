import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		
		session.setMaxInactiveInterval(60);
		if(session!=null) {
			String uname = req.getParameter("username");
			String pword = req.getParameter("password");
			session.setAttribute("one", uname);
			session.setAttribute("two", pword);
			String one = (String) session.getAttribute("one");
			pw.println("Hello Mr." + one + " it's your home page ");
			pw.println("<br>");
			pw.println("Username is:- " + session.getAttribute("one"));
			pw.println("<br>");
			pw.println("Password is:- " + session.getAttribute("two"));
			pw.println("<br><br>");
			LocalTime currentTime=LocalTime.now();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
			String currentTimeString=currentTime.format(formatter);
			pw.println("<meta http-equiv='refresh' content='60'>");
			pw.println("Username is:- " + session.getAttribute("one"));
			pw.println("<br>");
			pw.println("Password is:- " + session.getAttribute("two"));
			
		}
		else {
			RequestDispatcher rDispatcher=req.getRequestDispatcher("index.html");
			rDispatcher.include(req, resp);
			//resp.sendRedirect("index.html");
		}
		
		pw.write(" <a href= 'LogOut'>LogOut</a>");
	}
}
