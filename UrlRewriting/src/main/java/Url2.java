import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Url2 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw= resp.getWriter();
	String fname2= req.getParameter("one");
	String lname2= req.getParameter("two");
	
	pw.write("this is second servlet----");
	pw.write(fname2+" "+lname2);
	
	
	
	
}
}