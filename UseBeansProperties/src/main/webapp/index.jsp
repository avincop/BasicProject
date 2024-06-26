<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="p1.Emp" scope="application"></jsp:useBean>
<jsp:setProperty property="id" name="emp" value="101"/>
<jsp:setProperty property="name" name="emp" value="Avinash"/>
<jsp:getProperty property="id" name="emp" />
<jsp:getProperty property="name" name="emp"/>
<a href="index1.jsp">next</a>

</body>
</html>