package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentBean;
import validation.Validation;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int result=0;
		RequestDispatcher rd=null;
		
		
		StudentBean std=new StudentBean();
		std.setId(id);
		std.setName(name);
		HttpSession session= req.getSession();
		session.setAttribute("student1", std);
		
        Validation valid= new Validation();
        
        try {
			result=valid.saveData(std);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
        if(result>0) {
        	rd=req.getRequestDispatcher("welcome.jsp");
        	rd.forward(req, resp);
        }
        else {
        	rd=req.getRequestDispatcher("error.jsp");
        	rd.forward(req, resp);
        }
	}

}

