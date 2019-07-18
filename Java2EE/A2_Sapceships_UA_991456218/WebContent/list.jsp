<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Add another directive that say to TOMCAT that we are using a tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Records</title>

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
				<th>Rocket ID</th>
				<th>Name</th>
				<th>Height in Metres</th>
				<th>Launch Weight</th>
				<th class="center-align" colspan="2">Action</th>
			</tr>
		</thead>
		<c:forEach items="${pojos}" var="pojo">
			<tr>
				<td><c:out value="${pojo.rocketid}"/></td>
				<td><c:out value="${pojo.name}"/></td>
				<td><c:out value="${pojo.heightmetres}"/></td>
				<td><c:out value="${pojo.launchweight}"/></td>
					
				<td>
					<a class="waves-effect waves-light btn" href="Controller?action=edit&pojoid=<c:out value="${pojo.rocketid}"/>">Update</a>

				</td>
				<td class="centered">
					<a class="waves-effect waves-light btn" href="Controller?action=delete&pojoid=<c:out value="${pojo.rocketid}"/>">Delete</a>				
				</td>	
			</tr>
		</c:forEach>
		
		
	</table>
	<div class="section">
		<a class="waves-effect waves-light btn" href="Controller?action=insert">Add Record</a>
		<a class="waves-effect waves-light btn" href="searchByString.jsp">Filter by Name</a>
	</div>
	

</div>
</body>
</html>