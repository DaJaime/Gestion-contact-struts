<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"
	import = "org.lip6.struts.domain.Contact" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<title>Liste Contact</title>
</head>
<body>
<h1>Tous vos contacts</h1>
<table class="table">
<tr>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Adresse</th>
	<th>Mail</th>
	<th>Note</th>
	<th>Modifier</th>
</tr>
<% 

List<Contact> liste = new ArrayList<Contact>();
liste = (ArrayList<Contact>) request.getAttribute("liste");
int cpt = 0;
out.println("<tr>");

for(int i = 0;i<liste.size();i++)
{
	out.println("<tr>");
	out.println("<td>" + liste.get(i).getLastName()+ "</td>");
	out.println("<td>" + liste.get(i).getFirstName()+ "</td>");
	out.println("<td>" + liste.get(i).getAdresse()+ "</td>");
	out.println("<td>" + liste.get(i).getEmail()+ "</td>");
	out.println("<td>" + liste.get(i).getAutre()+ "</td>");
	pageContext.setAttribute("user", liste.get(i).getId());%>
	<td><html:link action="/AfficherInfosContact" paramName="user" paramId="name" scope="request" >Modifier</html:link></td>
	</tr><%
}

out.println("</tr>");
	%>
</table>
</body>
</html:html>

