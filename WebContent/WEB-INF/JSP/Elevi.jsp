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

<h2>Elevi</h2>
<table>
<tr>
	<th>Nume elev</th>
</tr>
<s:iterator value="listaElevi" var="elev">
	<tr>
		<td><s:property value="nume"/>
		<td><a href="deleteElev?numeElevDelete=<s:property value="#elev.nume"/>">delete</a></td>
		<td><a href="updateElev?numeElevUpdate=<s:property value="#elev.nume"/>">update</a></td>
	</tr>	
</s:iterator>
</table>
<br>


<h4>Adauga/modifica elev</h4>
<s:form action="addElev">
	<s:textfield name="elev.nume" label="Nume elev" value="%{elevUpdate.nume}"/> 
	<s:textfield name="elev.cont" label="Cont" value="%{elevUpdate.cont}"/>
	<s:textfield name="elev.parola" label="Parola" value="%{elevUpdate.Parola}"/>
	
	 <s:select name="listaElevCursuri" label="Selecteaza cursurile la care participa"
	 list="listaCursuri.{nume}" multiple="true" value="listaElevCursuriUpdate"/> 
	
	<s:submit value="Adauga"/>
</s:form>

<a href="homeProfesor">Acasa</a> <br>


</body>
</html>