<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"
	import = "org.lip6.struts.domain.Contact" 
	import = "org.lip6.struts.service.GroupeService"
	import = "org.lip6.struts.domain.Groupe"
	import = "org.lip6.struts.domain.Telephone" %>
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
<% String nomGroupe =  (String) request.getAttribute("nomGroupe"); %>
<title>Liste Contact</title>
</head>
<body>
<h1><% out.println(nomGroupe); %></h1>
<p>Groupe :</p>
<html:form action="/AfficherContactGroupe">
    <SELECT name="id">
	   <%
	   GroupeService gs = new GroupeService();
	   List<Groupe> listeGroupe = new ArrayList<Groupe>();
	   listeGroupe = gs.afficherGroupeName();
	   for(int i=0;i<listeGroupe.size();i++){
		   out.println("<OPTION name=\"id\" value=\""+listeGroupe.get(i).getId()+"\">"+listeGroupe.get(i).getNom()+"</OPTION>");
	   }
   %>
    </SELECT>
    <html:submit>Afficher</html:submit>
</html:form>

<table class="table">
<tr>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Adresse</th>
	<th>Mail</th>
	<th>Note</th>
	<th>Téléphone</th>
	<th>Modifier</th>
	<th>Supprimer</th>
</tr>
<% 

List<Contact> liste = new ArrayList<Contact>();
List<Telephone> tel = new ArrayList<Telephone>();
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
	pageContext.setAttribute("id", liste.get(i).getId());
	tel = (ArrayList<Telephone>) liste.get(i).getTel();
	for(int y=0;y<tel.size();y++)
	{
		out.println("<td>"+ tel.get(y).getDescription() + " " + tel.get(y).getNumero() +"</td>");
	}
	
	%>
	
	
	
	<td><html:link action="/AfficherInfosContact" paramName="id" paramId="id" scope="request" >Modifier</html:link></td>
	<td><html:link action="/SuppContact" paramName="id" paramId="id" scope="request" >Supprimer</html:link></td>
	</tr><%
}

out.println("</tr>");
	%>
</table>
</body>
</html:html>

