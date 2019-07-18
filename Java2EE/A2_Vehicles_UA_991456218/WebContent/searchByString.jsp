<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Query the Db</title>
</head>
<body>
<form action="Controller" method="get">
<fieldset>
<div>
	<label for="program">Engine Type</label> <input type="text" name="searchString"/>
	<input type="hidden" name="action" value="searchbyString">
</div>
<div>
	<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>