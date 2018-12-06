<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"
	import = "org.lip6.struts.domain.Contact"
	import = "org.lip6.struts.domain.Telephone" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>


<% 
Contact c = new Contact();
c = (Contact)request.getAttribute("contact");
List<Telephone> tel = new ArrayList<Telephone>();
tel = (ArrayList<Telephone>) c.getTel();
%>


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
<td align="right"> First Name
</td>
<td align="left">
<% out.println("<input type=\"text\" name=\"firstName\" size=\"30\" maxlength=\"30\" value=\""+c.getFirstName()+"\">"); %> </td>
</tr> <tr>
<td align="right"> Last Name
</td>
<td align="left">
<% out.println("<input type=\"text\" name=\"lastName\" size=\"30\" maxlength=\"30\" value=\""+c.getLastName()+"\">"); %> </td>
</tr>
<tr>
<td align="right"> Adresse
</td>
<td align="left">
<% out.println("<input type=\"text\" name=\"adresse\" size=\"30\" maxlength=\"30\" value=\""+c.getAdresse()+"\">"); %> </td>
</tr>
<tr>
<td align="right">
            E-mail address
</td>
<td align="left">
<% out.println("<input type=\"text\" name=\"email\" size=\"30\" maxlength=\"30\" value=\""+c.getEmail()+"\">"); %>
</td>
</tr>
<% 
/*for(int i = 0;i<tel.size();i++)
{
	 out.println("</tr>");
	 out.println("<td align=\"right\">");
	 out.println("Numero de Telephone");            
	 out.println("</td>");
	
	 out.println("<td align=\"left\">");
	 out.println("<input type=\"text\" name=\"numeroTel\" size=\"30\" maxlength=\"30\" value=\""+tel.get(i).getNumero()+"\">"); 
	 out.println("</td>");
	 out.println("</tr>");
	 out.println("<tr>");
	 out.println("<td align=\"right\">");
	 out.println("Description address");            
	 out.println("</td>");
	 out.println("<td align=\"left\">");
	 out.println("<input type=\"text\" name=\"descriptionTel\" size=\"30\" maxlength=\"30\" value=\""+tel.get(i).getDescription()+"\">"); 
	 out.println("</td>");
	 out.println("</tr>");
}*/
%>
<tr>
<td align="right"> Autre
</td>
<td align="left">
<% out.println("<input type=\"text\" name=\"autre\" size=\"30\" maxlength=\"30\" value=\""+c.getAutre()+"\">"); %>
 </td>
 <% out.println("<input type=\"hidden\" name=\"id\" size=\"30\" maxlength=\"30\" value=\""+c.getId()+"\">"); %>
</tr>
<tr>
<td align="right"> <html:submit>Save</html:submit>
</td> </tr>
  </table>
   </html:form>
   
   </body>
   </html:html>