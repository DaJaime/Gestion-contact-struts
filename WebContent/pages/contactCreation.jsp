<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "org.lip6.struts.service.GroupeService"
import = "org.lip6.struts.domain.Groupe"
import ="java.util.ArrayList"
import ="java.util.List"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>


<html:html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><bean:message key="add.contact"/></title> <html:base/>
</head>
<body bgcolor="white">
<html:form action="/AddContact">
<html:errors/>
<table>
<tr>
<td align="center" colspan="2">
<font size="4">Please Enter the Following Details</font> </tr>
<tr>
<td align="right"> First Name
</td>
<td align="left">
<html:text property="firstName" size="30" maxlength="30"/> </td>
</tr> <tr>
<td align="right"> Last Name
</td>
<td align="left">
<html:text property="lastName" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right"> Adresse
</td>
<td align="left">
<html:text property="adresse" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right">
            E-mail address
</td>
<td align="left">
<html:text property="email" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right"> Téléphone
</td>
<td align="left">
<html:text property="telephone" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right"> Téléphone description
</td>
<td align="left">
<html:text property="telephoneDescription" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right"> Autre
</td>
<td align="left">
<html:text property="autre" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td>Groupes :</td>
</tr>
   <%
   GroupeService gs = new GroupeService();
   List<Groupe> liste = new ArrayList<Groupe>();
   liste = gs.afficherGroupeName();
   for(int i=1;i<liste.size();i++){
	   if((i%2)==1){
		   out.println("</tr><tr>");
	   }
	   out.println("<td><input type=\"checkbox\" id=\""+liste.get(i).getId()+"\" name=\"idGroupes\" value=\""+liste.get(i).getId()+"\"> <label for=\""+liste.get(i).getId()+"\">"+liste.get(i).getNom()+"</label></td>");
   }
   %>
<tr>
<% out.println("<td><input type=\"checkbox\" id=\"1\" name=\"idGroupes\" value=\"1\" style=\"visibility:hidden\" checked></td>"); %>
<td align="right"> <html:submit>Save</html:submit>
</td> </tr>
  </table>
   </html:form>

   </body>
   </html:html>