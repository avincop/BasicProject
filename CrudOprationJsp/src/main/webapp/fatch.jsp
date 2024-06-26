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
<%-- <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/login"  
     user="root"  password="123456"/>   --%>
     
     <sql:query dataSource="${db}" var="rs">  
     SELECT * from table11;  
     </sql:query>
     
     <table border="2">  
<tr>  
<th>Id</th>  
<th>Name</th>  
<th>City</th>   
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.id}"/></td>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.city}"/></td>  

</tr>  
</c:forEach>  
</table>  

 <button onclick="window.location.href='index.html'">home</button>
</body>
</html>