<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Employee List</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Address</th>
		</tr>
		<c:forEach var="tab" items="${data}">
		<tr>
		<td>${tab.fname}</td>
		<td>${tab.femail}</td>
		<td>${tab.fdept}</td>
		<td>${tab.faddress}</td>
		</tr>
		
		
		</c:forEach>
	</table>
<br>
<br>
<h3> ${msg } </h3>
</body>
</html>