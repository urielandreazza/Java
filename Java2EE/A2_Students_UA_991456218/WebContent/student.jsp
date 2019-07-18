<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Add another directive that say to TOMCAT that we are using a tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Student Records</title>

<!-- CDNJS for the Front end Framework(Materialize CSS) -->

	<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<!-- end -->
</head>
<body>
<form action="StudentController" method="post">
<fieldset>
<div class="container">
	<table class="highlight centered">
		<tr>
			<td>StudentID:</td>
			<td><input type="text" name="studentId" readonly="readonly" value=<c:out value="${students.studentid}"/>>
		</td>
		</tr>
		<tr>
			<td>First Name:</td>
				<td><input type="text" name="firstname" value=<c:out value="${students.firstname}"/>>
			</td>
		</tr>
		<tr>
			<td>Last Name:</td>
				<td><input type="text" name="lastname" value=<c:out value="${students.lastname}"/>>
		</tr>
		<tr>
			<td>City:</td>
				<td><input type="text" name="city" value=<c:out value="${students.city}"/>>
		</tr>
		<tr>
			<td>Province:</td>
				<td><input type="text" name="province" value=<c:out value="${students.province}"/>>
		</tr>
		<tr>
			<td>Postal Code:</td>
				<td><input type="text" name="postalcode" value=<c:out value="${students.postalcode}"/>>
		</tr>
		
		<tr>
			<td>GPA:</td>
				<td><input type="text" name="gpa" value=<c:out value="${students.gpa}"/>>
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