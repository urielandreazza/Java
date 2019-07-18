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
<div class="container">
<p>Assignment #2 - CRUD</p>
<p>Uriel Andreazza - 991456218</p>
	<table class="highlight centered">
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Province</th>
				<th>Postal Code</th>
				<th>GPA</th>
				<th class="center-align" colspan="2">Action</th>
			</tr>
		</thead>
		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.studentid}"/></td>
				<td><c:out value="${student.firstname}"/></td>
				<td><c:out value="${student.lastname}"/></td>
				<td><c:out value="${student.city}"/></td>
				<td><c:out value="${student.province}"/></td>
				<td><c:out value="${student.postalcode}"/></td>
				<td><c:out value="${student.gpa}"/></td>
				
				<td>
					<a class="waves-effect waves-light btn" href="StudentController?action=edit&studentid=<c:out value="${student.studentid}"/>">Update</a>

				</td>
				<td class="centered">
					<a class="waves-effect waves-light btn" href="StudentController?action=delete&studentid=<c:out value="${student.studentid}"/>">Delete</a>				
				</td>	
			</tr>
		</c:forEach>
		
		
	</table>
	<div class="section">
		<a class="waves-effect waves-light btn" href="StudentController?action=insert">Add Student</a>
		<a class="waves-effect waves-light btn" href="searchStudentsInCity.jsp">Filter by City</a>
		<a class="waves-effect waves-light btn" href="searchStudentsWithGPA.jsp">Filter by GPA</a>
	</div>
	

</div>
</body>
</html>