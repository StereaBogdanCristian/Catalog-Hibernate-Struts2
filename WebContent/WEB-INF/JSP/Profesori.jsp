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

<h2>Profesori</h2>
<table>
<tr>
	<th>Nume profesor</th>
</tr>
<s:iterator value="listaProfesori" var="profesor">
	<tr>
		<td><s:property value="nume"/>
		<td><a href="deleteProfesor?numeProfesorDelete=<s:property value="#profesor.nume"/>">delete</a></td>
	</tr>	
</s:iterator>
</table>
<br>

<h4>Adauga profesor</h4>
<s:form action="addProfesor" method="post">
	<s:textfield name="profesor.nume" label="Nume profesor" value=""/>
	<s:textfield name="profesor.cont" label="Cont" value=""/>
	<s:textfield name="profesor.parola" label="Parola" value=""/>
	
	<s:submit value="Adauga"/>
</s:form>

<a href="homeProfesor">Acasa</a> <br>

</body>
</html>