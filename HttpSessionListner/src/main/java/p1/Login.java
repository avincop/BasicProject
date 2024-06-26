package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String  name= req.getParameter("fname");
		String pass= req.getParameter("pass");
		PrintWriter pWriter= resp.getWriter();
		pWriter.println("welcome"+" "+name);
		HttpSession session=req.getSession();
		session.setAttribute("name", name);
		
		pWriter.println("<a href='logout'>logout</a>");
		
	}

}
