<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Add another directive that say to TOMCAT that we are using a tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Modify a Record</title>

<!-- CDNJS for the Front end Framework(Materialize CSS) -->

	<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<!-- end -->
</head>
<body>
<form action="Controller" method="post">
<fieldset>
<div class="container">
	<table class="highlight centered">
		<tr>
			<td>Rocket ID:</td>
			<td><input type="text" name="rocketID" readonly="readonly" value=<c:out value="${pojos.rocketid}"/>>
		</td>
		</tr>
		<tr>
			<td>Name:</td>
				<td><input type="text" name="name" value=<c:out value="${pojos.name}"/>>
			</td>
		</tr>
		<tr>
			<td>Height in Metres:</td>
				<td><input type="text" name="heightmetres" value=<c:out value="${pojos.heightmetres}"/>>
		</tr>
		<tr>
			<td>Launch Weight:</td>
				<td><input type="text" name="launchweight" value=<c:out value="${pojos.launchweight}"/>>
		</tr>
	</table>
	<div class="section">
		<input type="submit" value="Submit" />
	</div>
</div>
</fieldset>
</form>


</body>
</html>