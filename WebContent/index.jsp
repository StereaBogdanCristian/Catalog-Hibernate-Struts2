<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
</head>
<body>
	<h1>Catalog</h1>
	<h2>Pagina logare</h2>
	
	<s:form action="login" method="post">
		<s:textfield label="Cont " key="user"/>
		<s:password label="Parola  " key="password"/>
		<s:submit value="Login" />
	</s:form>
	
</body>
</html>