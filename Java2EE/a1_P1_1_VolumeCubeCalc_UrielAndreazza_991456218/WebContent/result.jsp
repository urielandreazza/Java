<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatted Output</title>
</head>
<body>
<!-- Receives the Volume from the Servlet and print the result -->
<h2>Uriel Andreazza - 991456218</h2>
<h2>Result</h2>
	<%
		int volume = (Integer) request.getAttribute("volume");
	%>
	
	<table>
		<tr>
			<td>Volume:</td>
			<td><%= volume %></td>
		</tr>
	</table>
</body>
</html>