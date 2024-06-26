<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is second jsp page</h1>
<% session.invalidate(); %>
<%= session.getAttribute("name1")
    
%>
<%= session.getAttribute("name2")%>
</body>
</html>