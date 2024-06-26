import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HttpServletDemo extends HttpServlet {

	
//	public void init(ServletConfig config) {
//	  
//	}
	
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		PrintWriter pw=res.getWriter();
//		pw.println("Hello world");
//	}

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String st=getInitParameter("Name123");
		resp.getWriter().println(st);
		System.out.println("service method is calling");
				
		
		
		
	}
//		resp.getWriter().println("doGet is calling");
//		Calendar calendar= Calendar.getInstance();
//		resp.getWriter().println(calendar);
//		resp.setHeader("name", "java");
//		String string= resp.getHeader("name");
//		resp.getWriter().println(string);
		
		
		
		
//		PrintWriter pw2= resp.getWriter();
//		Enumeration<String> headerNam= req.getHeaderNames();
//		while(headerNam.hasMoreElements()) {
//			String headerName= headerNam.nextElement();
//			String headerValue= req.getHeader(headerName);
//			pw2.println(headerName+""+headerValue);
			
		
	}

	
	
	

		
	

