import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<a href='Test1'>" + "        <button type=\"button\">Servlet2</button>\r\n" + "    </a>");
		out.println("</body>");
		out.println("</html>");
		ServletContext sc= getServletContext();
		//pw.println(sc);
		//pw.println(sc.getAttribute("name1"));
		sc.setAttribute("name2", "ram");
		//pw.println(sc.getAttribute("name1"));
		String st=sc.getInitParameter("name1");
		System.out.println(st);
		out.println(st);
		
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
