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
	
	<h3>Situatia notelor</h3>
	
	<table> 
      <tr>
         <td>Materia</td>
         <td>Nota</td>
      </tr>
      <s:iterator value="elev.getListaNote()">	
         <tr>
            <td><s:property value="key"/></td>
            <td><s:property value="value"/></td>
           </tr>
      </s:iterator>	
   </table> 
  
   <br>
   <a href="elevCursuri">Afiseaza toate cursurile la care sunt inscris </a>
   <br>
   <a href="elevProfesori">Afiseaza toti profesorii la cursurile carora sunt inscris</a>
   <br>
   <a href="logout">Logout</a>
</body>
</html>