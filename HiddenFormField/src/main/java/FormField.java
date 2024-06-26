import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormField extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw= resp.getWriter();
	String name1= req.getParameter("name");
	String pas= req.getParameter("pass");
	int pass1=Integer.parseInt(pas);
	
	pw.write("<form action='FormField2' method='post'>");
	pw.write("<input type='hidden' name='name123' value="+name1+">");
	pw.write("<input type='hidden' name='pass123' value="+pass1+">");
	pw.write("<input type='submit' value='Submit'>");
	pw.write("</form");
	
	
}
}
