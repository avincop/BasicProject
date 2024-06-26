<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="another.jsp">
     <jsp:param value="<%=request.getParameter(\"name\")%>" name="name1"/>
     <jsp:param value="<%=request.getParameter(\"pass\") %>" name="pass1"/>
     </jsp:forward>
    
 <%-- <jsp:forward page="another.jsp">
     <jsp:param value='<%=request.getParameter("name")%>' name="name1"/>
     <jsp:param value='<%=request.getParameter("pass") %>' name="pass1"/>
    </jsp:forward> --%>
    
    
<%-- <jsp:forward page="another.jsp">
     <jsp:param value="${param.name}" name="name1"/>
     <jsp:param value="${param.pass}" name="pass1"/>
    </jsp:forward> --%>
    
    
<%-- <jsp:forward page="another.jsp">
     <jsp:param value='${param.name}' name="name1"/>
     <jsp:param value='${param.pass}' name="pass1"/>
    </jsp:forward>
 --%>    

</body>
</html>