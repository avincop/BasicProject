import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw= resp.getWriter();
		ServletContext sc= getServletContext();
		//pw.println(sc);
		//pw.println(sc.getAttribute("name1"));
		//sc.setAttribute("name1", "ram");
		//pw.println(sc.getAttribute("name1"));
		String st=sc.getInitParameter("name1");
		System.out.println("second class");
		System.out.println(st);
		pw.println(st);
		System.out.println(sc.getAttribute("name2"));
		pw.println(sc.getAttribute("name2"));
//		String st1=sc.getInitParameter("name2");
//		System.out.println(st1);
//		pw.println(st1);
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
