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
			<td>FlightID:</td>
			<td><input type="text" name="carId" readonly="readonly" value=<c:out value="${pojos.flightid}"/>>
		</td>
		</tr>
		<tr>
			<td>Flight NO:</td>
				<td><input type="text" name="make" value=<c:out value="${pojos.flightno}"/>>
			</td>
		</tr>
		<tr>
			<td>Departing City:</td>
				<td><input type="text" name="model" value=<c:out value="${pojos.departingcity}"/>>
		</tr>
		<tr>
			<td>Destination:</td>
				<td><input type="text" name="enginetype" value=<c:out value="${pojos.destination}"/>>
		</tr>
		<tr>
			<td>Distance in KM</td>
				<td><input type="text" name="gallonthousandmilesgas" value=<c:out value="${pojos.distanceinkm}"/>>
		</tr>
				<tr>
			<td>Daily Flights</td>
				<td><input type="text" name="aiassistant" value=<c:out value="${pojos.dailyflights}"/>>
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