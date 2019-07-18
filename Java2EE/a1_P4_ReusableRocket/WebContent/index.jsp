<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Data</title>
</head>
<body>

<h1>Reusable Rocket Registration Form</h1>
<h2>Uriel Andreazza - 991456218</h2>
<!-- Prompt the User to add the information about the rockets -->

	<form action="Registration" method="get">
		<table>
		
			<tr>
				<td>Height:</td>
				<td><input type="text" name="height"/></td>
			</tr>
			<tr>
				<td>Weight:</td>
				<td><input type="text" name="weight"/></td>
			</tr>
			<tr>
				<td>Number of Re-uses:</td>
				<td><input type="text" name="reUses"/></td>
			</tr>		
			<tr>
				<td>Rocket Name:</td>
				<td><input type="text" name="name"/></td>
			</tr>		
		</table>	
		<input type="submit" value="Save"/>
	</form>
</body>
</html>