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
<%  int id= Integer.parseInt(request.getParameter("id"));
    String name= request.getParameter("name");
   String city= request.getParameter("city");
   request.setAttribute("id1", id);
   request.setAttribute("name1", name);
   request.setAttribute("city1", city);

%>
<%-- <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/login"  
     user="root"  password="123456"/>  --%>
     
     
      <sql:query dataSource="${db}" var="checkExisting">
    SELECT COUNT(*) AS count FROM table11 WHERE id = ?
    <sql:param value="${id1}" />
</sql:query>
     
     <c:choose>
    <c:when test="${checkExisting.rows[0].count > 0}">
        <sql:update dataSource="${db}" var="result">UPDATE table11 SET name = ?, city = ? WHERE id = ?
     <sql:param value="${name1}"></sql:param>
     <sql:param value="${city1}"></sql:param>
     <sql:param value="${id1}"></sql:param>
     </sql:update>
     <c:if test="${result>0}">
     <h1>update successful</h1>
     </c:if>
     
     <c:if test="${result==0}">
     <h1>not update</h1>
     </c:if>
    </c:when>
    <c:otherwise>
        <h1>id doesn't exist</h1>
    </c:otherwise>
</c:choose>
     
     
 <button onclick="window.location.href='index.html'">home</button>
</body>
</html>