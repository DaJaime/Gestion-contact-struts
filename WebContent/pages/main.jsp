<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %> <%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %> <html:html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><bean:message key="main.page.title"/></title>
      </head>
      <body>
		<h1><bean:message key="main.page.menu"/></h1> 
		<h4><a href="ContactCreation.do"><bean:message key="main.addcontact.link"/></a></h4><br> 
		<h4><a href="ContactModification.do"><bean:message key="main.updatecontact.link"/></a></h4><br>
        <h4><a href="ContactSuppression.do"><bean:message key="supp.contact"/></a></h4><br> 
</body>
   </html:html>