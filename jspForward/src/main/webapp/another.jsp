<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>getting from the index.jsp page</h3>
  <% String name=request.getParameter("name1");
     String pass=request.getParameter("pass1");
      out.println(name+" "+pass);
    %>
    
    <hr>
     <h4>getting from the index.html</h4>
    <%= request.getParameter("name") +" "+
        request.getParameter("pass") %>
        
        <hr>
        <h4>using param object in jsp</h4>
        ${param.name}
        ${param.pass}
        
        <hr>
        ${param.name1}
        ${param.pass1}

</body>
</html>