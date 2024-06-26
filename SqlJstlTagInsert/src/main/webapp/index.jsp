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
<% String name= request.getParameter("name");
   String city= request.getParameter("city");
   request.setAttribute("name1", name);
   request.setAttribute("city1", city);

%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/login" user="root" password="123456"  />
<sql:update dataSource="${db}" var="value">insert into table1 values(?,?)
<sql:param value="${name1}"></sql:param>
<sql:param value="${city1}"></sql:param>
</sql:update>
<c:if test="${value>0}">
<h1>record inserted</h1>
</c:if>
<table border="300">
<tr>
<th>name</th>
<th>city</th>
</tr>
<h2>fatch database value</h2>
<sql:query var="data" dataSource="${db}">select * from table1</sql:query>
<c:forEach var="dbval" items="${data.rows}">
<tr>
<td><c:out value="${dbval.tName }"></c:out></td>
<td><c:out value="${dbval.tCity}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>