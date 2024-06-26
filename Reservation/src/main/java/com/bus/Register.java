package com.bus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String to= req.getParameter("to");
		String from= req.getParameter("from");
		String name= req.getParameter("name");
		String fname= req.getParameter("fname");
	    System.out.println(to+" "+ from);
	}

}
