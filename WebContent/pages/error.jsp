<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
 <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
 
 <html:html>
      <head>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><bean:message key="title.error"/></title> </head>
      <body>
            <html:errors/><bean:message key="title.error"/> <br/>
      </body>
</html:html>
 