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
     user="root"  password="123456"/>  
     
     <sql:query dataSource="${db}" var="rs">  
     SELECT * from table1;  
     </sql:query>
     
     <table border="2" width="100%">  
<tr>  
<th>tId</th>  
<th>tName</th>  
<th>tCity</th>   
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.tId}"/></td>  
<td><c:out value="${table.tName}"/></td>  
<td><c:out value="${table.tCity}"/></td>  

</tr>  
</c:forEach>  
</table>  
</body>
</html>