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
		String uname = req.getParameter("fname");

		HttpSession session = req.getSession();

		session.setAttribute("one", uname);

		session.setMaxInactiveInterval(60);
		if (session != null && session.getAttribute("one") != null) {
			pw.println("Username is:- " + session.getAttribute("one"));
			pw.println("<br>");

			pw.println("<br><br>");
			LocalTime currentTime = LocalTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String currentTimeString = currentTime.format(formatter);
			
			pw.println("Current Time: " + currentTimeString);
			// pw.println("<meta http-equiv='refresh' content='60'>");
			resp.setHeader("Refresh", "60");

		} else {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("index.html");
			rDispatcher.include(req, resp);

			// resp.sendRedirect("index.html");

		}

		// pw.write(" <a href= 'LogOut'>LogOut</a>");
	}
}
