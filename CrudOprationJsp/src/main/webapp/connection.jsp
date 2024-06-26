<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/login"  
     user="root"  password="123456" scope="application"/> 
    <c:if test="${not empty db}">
    <h1>Connection established</h1>
</c:if>
     <button onclick="window.location.href='index.html'">home</button>
</body>
</html>