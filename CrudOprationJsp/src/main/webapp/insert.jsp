<%@page import="emp.EmpInsert"%>
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
   emp.EmpInsert obj= new emp.EmpInsert();    
    obj.setId(id);
    obj.setName(name);
    obj.setCity(city);
    request.setAttribute("emp", obj); 
  /* request.setAttribute("id1", id);
   request.setAttribute("name1", name);
   request.setAttribute("city1", city);  */

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
        <h1>ID already exists!</h1>
    </c:when>
    <c:otherwise>
        <sql:update dataSource="${db}" var="value">
            INSERT INTO table11 VALUES (?, ?, ?)
            <sql:param value="${emp.getId()}" />
            <sql:param value="${emp.getName()}" />
            <sql:param value="${emp.getCity()}" />
        </sql:update>
        <c:if test="${value > 0}">
            <h1>Record inserted</h1>
        </c:if>
    </c:otherwise>
</c:choose></c:catch>
<c:out value="${ exec}"></c:out>
 <button onclick="window.location.href='index.html'">home</button>


</body>
</html>