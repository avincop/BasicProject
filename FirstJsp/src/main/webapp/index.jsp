<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
       Connection connection;
   try{
	   Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/login";
		String username="root";
		String password="123456";
       connection= DriverManager.getConnection(url,username,password);
       System.out.println("connection success");
	
	   String name=request.getParameter("fname");
	   String pass=request.getParameter("pass");
	   String inserquery= "Insert into user12(name, pass) values(?,?)";
	   PreparedStatement ps= connection.prepareStatement(inserquery);
	   ps.setString(1, name);
	   ps.setString(2, pass);
	   ps.executeUpdate();
	   out.println("successfull data added");
	   
	   
	   
   }catch(Exception e){
	   out.println(e);
   }


%>

</body>
</html>