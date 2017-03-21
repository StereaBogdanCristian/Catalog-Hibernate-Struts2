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

	<h3>Situatie note la cursul <s:property value="numeCursAles"/></h3>

	<table>
		<tr>
			<th>Nume elev</th>
			<th>Nota</th>
		</tr>

	<s:iterator value="eleviListaNote" var="elevNota">
   			 <tr>
   			 	 <td> <s:property value="key"/> </td>
   			 	 <td> <s:property value="value"/> </td>
   				 <td> <a href="eleviListaNoteModifica?numeElevAles=<s:property value="#elevNota.key"/>">Modifica</a> </td>
   			</tr>
	</s:iterator>
	</table>
	<br>
	
	<h4>Acorda nota</h4>
	
	<s:form action="addNota">
			<s:textfield name="elevNotaAcordata" label="Nota" value="%{elevModifica.getListaNote().get(numeCursAles)}"/>
	
			<s:select name="elevNotaNume" label="Selecteaza elevul"
			list="listaCursElevi.{nume}" value="%{elevModifica.nume}"/>
	
			<s:submit value="OK"/>
	</s:form>
	
	<a href="homeProfesor">Acasa</a> 
	
	
</body>
</html>