<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<td>key</td>
<td>value</td>
</tr>

<c:forEach var="map1" items="${newMap}">
 <tr>
   <td> <c:out value="${ map1.key}"></c:out></td>
    <td> <c:out value="${ map1.value}"></c:out></td>
</c:forEach>
</tr>
</table>
</body>
</html>