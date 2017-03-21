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
	Bine ai venit, <s:property value="elev.getNume()"/>!
	
	<h3>Esti inscris la urmatoarele cursuri:</h3>
	
	
	<s:iterator value="elev.getListaElevCurs()">
   			 <s:property value="nume"/><br>
	</s:iterator>

	<br>
 	  <a href="homeElev">Acasa</a>

	<br>
 	  <a href="logout">Logout</a>
 	  
</body>
</html>