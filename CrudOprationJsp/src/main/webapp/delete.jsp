<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id= Integer.parseInt(request.getParameter("id")); 
request.setAttribute("id1", id);

%>
<c:catch var="exec">
<%-- <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/login"  
     user="root"  password="123456"/>  --%>
     
     <sql:query dataSource="${db}" var="checkExisting">
    SELECT COUNT(*) AS count FROM table11 WHERE id = ?
    <sql:param value="${id1}" />
</sql:query>
     
     <c:choose>
    <c:when test="${checkExisting.rows[0].count > 0}">
        <sql:update dataSource="${db}" var="result">DELETE FROM table11 WHERE id =?
     <sql:param value="${id1}"></sql:param>
     </sql:update>
     <c:if test="${result>0}">
     <h1>data deleted</h1>
        </c:if>
    </c:when>
    <c:otherwise>
        <h1>id doesn't exist</h1>
    </c:otherwise>
</c:choose></c:catch>
     <c:out value="${exec }"></c:out>
     
      <button onclick="window.location.href='index.html'">home</button>



</body>
</html>