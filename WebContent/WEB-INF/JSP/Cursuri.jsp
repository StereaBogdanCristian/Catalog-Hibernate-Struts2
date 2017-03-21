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

<h2>Cursuri</h2>
<table>
<tr>
	<th>Nume curs</th>
</tr>
<s:iterator value="listaCursuri" var="curs">
	<tr>
		<td><s:property value="nume"/>
		<td><a href="delete?numeCurs=<s:property value="#curs.nume"/>">delete</a></td>
	</tr>	
</s:iterator>
</table>
<br>

<h4>Adauga curs</h4>
<s:form action="add" method="post">
	<s:textfield name="curs.nume" label="Nume curs" value=""/>
	
	<s:select name="profesor.nume" label="Selecteaza profesorul titular"
	list="listaProfesori.{nume}" value=""/>
	
	<s:submit value="Adauga"/>
</s:form>

<a href="homeProfesor">Acasa</a> <br>

</body>
</html>