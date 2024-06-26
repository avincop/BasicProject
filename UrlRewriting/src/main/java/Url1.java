import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Url1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
	String fname1= req.getParameter("fname");
	String lname1= req.getParameter("lname");
	
	pw.write("this is first servlet----");
	pw.write(fname1+" "+lname1);
	
	pw.write(" <a href= 'Url2?one="+fname1+" &two="+lname1+"'>click</a>");
	
	
}
}
