import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Filter1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pWriter=response.getWriter();
		String number= request.getParameter("number");
		if(number.equals("10")) {
			if(request instanceof HttpServletRequest) {
				HttpServletRequest req= (HttpServletRequest)request;
				HttpSession session= req.getSession();
				 session.setAttribute("name1", number);
					chain.doFilter(request, response);
			}
		}
		else {
			pWriter.println("invalid number");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		 
		 
		

		
	}

	
	}
