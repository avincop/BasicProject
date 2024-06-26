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
<%-- <c:out value="Hello java developer"></c:out>
<c:set var="abc" value="1501"></c:set>
<c:out value="${abc}"></c:out>
<c:if test="${abc<1500}">
<h1><c:out value="abc is a big number"></c:out></h1>
</c:if>
<c:import url="https://www.javatpoint.com/jstl-core-choose-when-otherwise-tag"></c:import> --%>
<%-- <c:redirect url="https://www.javatpoint.com/jstl-core-choose-when-otherwise-tag"></c:redirect> --%>

<%-- <c:forEach var="i" begin="0" end="10" >
  <c:out value="${i}"></c:out>
</c:forEach> --%>

 
<%-- 
<c:set value="11" var="num"></c:set>  
<c:choose>  
<c:when test="${num%2==0}">  
<c:out value="${num} is even number"></c:out>  
</c:when>  
<c:otherwise>  
<c:out value="${num} is odd number"></c:out>  
</c:otherwise>  
</c:choose>   --%>


<%-- <c:forTokens items="Ram-Shyam-Hari" delims="-" var="name">
<c:out value="${name}"></c:out>
</c:forTokens> --%>
<c:url value="index1.jsp" var="go" >
<c:param name="name1" value="Avinash"></c:param>
<c:param name="name2" value="Desktop"></c:param>
</c:url>
<a href="${go}">goto</a>
</body>
</html>