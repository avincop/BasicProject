<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.EmpBean, logic.EmpDataInsertion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id"));
   String  name=request.getParameter("name");
   
   EmpBean emp=new EmpBean();
   emp.setId(id);
   emp.setName(name);
   
   EmpDataInsertion empData=new EmpDataInsertion();
   int result=empData.saveData(emp);
   if(result>0){
	   out.println("record inserted");
   }
   else{
	   out.println("error");
   }


%>

</body>
</html>