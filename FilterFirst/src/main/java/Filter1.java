import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
@WebFilter("/servlet1")
public class Filter1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pWriter=response.getWriter();
//		System.out.println("befor");
//		chain.doFilter(request, response);
//		System.out.println("after");
		String number= request.getParameter("number");
		if(number.equals("10")) {
			chain.doFilter(request, response);
		}
		else {
			pWriter.write("invalid number");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
	}

	
	}

