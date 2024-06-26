import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainLogin2 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	HttpSession session = req.getSession();
	String one= (String) session.getAttribute("one");
	pw.println("Hello Mr."+one+" it's your home page ");
	pw.println("<br>");
	pw.println("Username is:- "+session.getAttribute("one"));
	pw.println("<br>");
	pw.println("Password is:- "+session.getAttribute("two"));
	pw.println("<br><br>");
	pw.write(" <a href= 'Test'>Back</a>");
	pw.write(" <a href= 'LogOut'>LogOut</a>");
}
}
