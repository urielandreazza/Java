<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatted Output</title>
</head>

<style>
table#nat{
	width:50%;
	background-color: #c48ec5;
}
</style>
<body>
	<%
		String  make = request.getParameter("make");
		String model = request.getParameter("model");
		String   eff = request.getParameter("eff");
	%>
	
	<table id="nat">
		<tr>
			<td>Manufacturer: </td>
			<td><%= make %></td>
		</tr>
		<tr>
			<td>Model: </td>
			<td><%= model %></td>
		</tr>
		<tr>
			<td>Efficiency</td>
			<td><%= eff %></td>
		</tr>
	</table>
</body>
</html>