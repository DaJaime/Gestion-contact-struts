<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Adresse</th>
	<th>Mail</th>
	<th>Note</th>
</tr>
<% 
List<String> liste = new ArrayList<String>();
liste = (ArrayList<String>) request.getAttribute("liste");
Iterator<String> it = liste.iterator();
int cpt = 0;
out.println("<tr>");
while (it.hasNext()) {
	if (cpt == 5){
		out.println("</tr>");
		out.println("<tr>");
		cpt = 0;
	}
	out.println("<td>"+it.next()+"</td>");
	cpt ++;
 
}
out.println("</tr>");
	%>
</table>


</body>
</html>