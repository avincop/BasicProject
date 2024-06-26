package ServletDemoFirst;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//@WebServlet("/first")  
public class TestServlet implements Servlet{
	ServletConfig config= null;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method calling");		
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service method calling");
		//String st= req.getParameter()
		PrintWriter outPrintWriter =res.getWriter();
		outPrintWriter.println("Hello World");
		
		        
		  
		
//		res.sendRedirect("home.html");
		
	}
	public void destroy() {
		System.out.println("destroy method calling");
		
	}

	
	public ServletConfig getServletConfig() {
		return config;
	}

	
	public String getServletInfo() {
		
		return "Servlet";
	}

	
	
}
	
	
	

