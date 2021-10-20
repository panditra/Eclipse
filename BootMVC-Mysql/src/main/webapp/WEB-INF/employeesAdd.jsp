<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
      <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>  
      
      <script>  
         $(function() {  
            $( "#datepick-1" ).datepicker({  
               appendText:"(yy-mm-dd)",  
             //  dateFormat:"yy-mm-dd",  
               dateFormat:"dd-mm-yy",  
              // altField: "#datepick-2",  
              // altFormat: "DD, d MM, yy"  
            });  
         });  
      </script>  
      <style>
      .error {
         color: #ff0000;
      }
     </style>
</head>
<body>
	<h1>Add Employee</h1>
	<form:form action = "${pageContext.request.contextPath}/save" modelAttribute="employee">
<%-- 	<form:errors path = "*" cssClass = "error" /><br/> --%>
		Enter Name: <form:input path="name"/> <form:errors path = "name" cssClass = "error" /><br/>
		
		Select Gender: <form:radiobutton path="gender" value = "Male"/>Male&nbsp;
					<form:radiobutton path="gender" value = "Female"/>Female&nbsp;<br/>
		Departement: 
		<form:select path="department">
			<form:option value="Support">Support</form:option>
			<form:option value="Testing">Testing</form:option>
			<form:option value="Development">Development</form:option>
			<form:option value="Business Analyst">Business Analyst</form:option>
		</form:select><br/>
		<%--    Birth: <form:input path="dob" type = "date"/><br/>   --%>
		    Birth: <form:input path="dob" id="datepick-1" /><br/>   
		<form:hidden path = "id"/>
		<button type = "submit">Save</button>
	</form:form>
</body>
</html>