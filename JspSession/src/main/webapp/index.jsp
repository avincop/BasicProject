<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is first jsp page</h1>
<% String fname= request.getParameter("name1");
     String lname= request.getParameter("name2");



session.setAttribute("name1", fname);
session.setAttribute("name2", lname);
%>
<a href="second.jsp">second page</a>

</body>
</html>