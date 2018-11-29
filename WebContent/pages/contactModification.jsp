<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><bean:message key="update.contact"/></title> <html:base/>
</head>
<body bgcolor="white">
<html:form action="/UpdateContact">
<html:errors/>
<table>
<tr>
<td align="center" colspan="2">
<font size="4">Please Enter the Following Details</font> </tr>
<tr>
<td align="right">
Contact Id
</td>
<td align="left">
<html:text property="id" size="30" maxlength="30"/> </td>
</tr> <tr>
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
<html:text property="email" size="30" maxlength="30" value="Toto"/> </td>
</tr>
<tr>
<td align="right"> Autre
</td>
<td align="left">
<html:text property="autre" size="30" maxlength="30"/> </td>
</tr>
<tr>
<td align="right"> <html:submit>Save</html:submit>
</td> </tr>
  </table>
   </html:form>
   </body>
   </html:html>