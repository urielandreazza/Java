<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Data</title>
</head>
<body>

<h1>Hybrid Car Registration Form</h1>
<h2>Uriel Andreazza - 991456218</h2>
<!-- Request the input from the user -->

	<form action="Registration" method="get">
		<table>
		
			<tr>
				<td>Manufacturer:</td>
				<td><input type="text" name="make"/></td>
			</tr>
			<tr>
				<td>Model:</td>
				<td><input type="text" name="model"/></td>
			</tr>
			<tr>
				<td>Efficiency:</td>
				<td><input type="text" name="eff"/></td>
			</tr>		
		</table>	
		<input type="submit" value="Save"/>
	</form>
</body>
</html>