import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw= resp.getWriter();
		String name= req.getParameter("fname");
		
		Cookie cookie= new Cookie("myname", name);
		resp.addCookie(cookie);
		pw.write("welcome "+name );
		pw.println("<a href='MainCookie2'>" + "        <button type=\"button\">Servlet2</button>\r\n" + "    </a>");
		
	}

}
