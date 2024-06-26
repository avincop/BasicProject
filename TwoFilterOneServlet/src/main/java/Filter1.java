import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pWriter=response.getWriter();
		System.out.println("filter1 befor");
		chain.doFilter(request, response);
		System.out.println("filter1 after");
//		String number= request.getParameter("number");
//		if(number.equals("10")) {
//			chain.doFilter(request, response);
//		}
//		else {
//			pWriter.write("invalid number");
//			request.getRequestDispatcher("index.html").include(request, response);
//		}
		
	}

	
	}
