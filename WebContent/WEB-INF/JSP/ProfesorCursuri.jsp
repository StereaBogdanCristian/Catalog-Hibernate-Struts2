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
	
	<h3>Sustii urmatoarele cursuri:</h3>
	
	
	<s:iterator value="profesor.getListaProfesorCurs()">
   			 <s:property value="nume"/><br>
	</s:iterator>

	<br>
 	    <a href="profesorElevi">Elevii care participa la cursurile pe care le predai</a> <br>
 	<br>
 		<a href="acordaNota">Acorda note</a>  <br>
  	<br>
  	<br>
		<a href="gestioneazaCursuri">Gestioneaza cursuri</a> <br>
		<a href="gestioneazaElevi">Gestioneaza elevi</a>  <br>
		<a href="gestioneazaProfesori">Gestioneaza profesori</a>  <br>
	<br>
 	<br>
 	  <a href="logout">Logout</a>
 	  
</body>
</html>