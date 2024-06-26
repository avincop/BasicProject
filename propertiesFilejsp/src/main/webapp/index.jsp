<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
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
       Properties prop= new Properties();
       String path= application.getRealPath("pro.properties");
       FileInputStream file= new FileInputStream(path);
       prop.load(file);
       String driver= (String)prop.get("driver");
       String url= (String)prop.get("url");
       String user= (String)prop.get("user");
       String password= (String)prop.get("password");
       
       Class.forName(driver);
       Connection con=DriverManager.getConnection(url, user, password);
       PreparedStatement ps=con.prepareStatement("INSERT INTO table11 VALUES (?, ?, ?)");
       ps.setInt(1, 2);
       ps.setString(2, "jay");
       ps.setString(3, "Rom");
       int i=ps.executeUpdate();
       if(i>0){
    	   out.println("inserted");
       }



%>

</body>
</html>