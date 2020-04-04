<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h2>user login</h2>
	<form:form action="logindata" method="post" modelAttribute="bean">
	
		Enter name: <form:input path="fname"/>
		<br />
		
		<input type="submit" value="LOGIN">


	</form:form>
