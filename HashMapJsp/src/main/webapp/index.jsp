<%@page import="java.util.HashMap"%>
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
<% HashMap<Integer, String> hm=new HashMap<Integer, String>(); 
       hm.put(101, "java");
       hm.put(104, "c++");
       hm.put(103, "dsa");
       hm.put(102, "python");
       request.setAttribute("map", hm);
%>
<table border="2">
    <tr>
    <td>key</td>
    <td>value</td>
      </tr>
   <c:forEach var="mapvalue" items="${map}">
   <tr>
   <td> <c:out value="${ mapvalue.key}"></c:out></td>
    <td> <c:out value="${ mapvalue.value}"></c:out></td>  
   </c:forEach>   
    </tr>
</table>
 <c:set var="newMap" value="${map}" scope="application"></c:set>
<a href="index1.jsp">next</a>
</body>
</html>