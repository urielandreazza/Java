<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search for Students within a given City</title>
</head>
<body>
<form action="StudentController" method="get">
<fieldset>
<div>
	<label for="program">City</label> <input type="text" name="city"/>
	<input type="hidden" name="action" value="searchstudentsfromcity">
</div>
<div>
	<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>