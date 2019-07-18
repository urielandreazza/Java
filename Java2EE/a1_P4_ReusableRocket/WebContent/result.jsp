<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatted Output</title>
</head>
<style>
  table#nat {
   width: 50%;
   background-color: #c48ec5;
  }
</style>

<body>
<h2>Uriel Andreazza - 991456218</h2>
	<%
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String reUses = request.getParameter("reUses");
		String   name = request.getParameter("name");
	%>
	
	<table id="nat">
		<tr>
			<td>Height:</td>
			<td><%= height %></td>
		</tr>
		<tr>
			<td>Weight:</td>
			<td><%= weight %></td>
		</tr>
		<tr>
			<td># of Re-uses:</td>
			<td><%= reUses %></td>
		</tr>
		<tr>
			<td>Rocket Name:</td>
			<td><%= name %></td>
		</tr>
	</table>
</body>
</html>