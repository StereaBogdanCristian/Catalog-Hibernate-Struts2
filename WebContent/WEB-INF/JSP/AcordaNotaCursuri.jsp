<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Bine ai venit, <s:property value="profesor.getNume()"/>!
	
	<h3>Alege o grupa pentru a acorda note</h3>
	
	
	<s:iterator value="listaCursuriProfesor" var="cursit">
   			 	<s:property value="nume"/>
   				<a href="afiseazaEleviCurs?numeCursAles=<s:property value="#cursit.nume"/>">Alege</a> 
   				<br>
	</s:iterator>
	<br>
	<br>
 	  <a href="homeProfesor">Acasa</a>

</body>
</html>