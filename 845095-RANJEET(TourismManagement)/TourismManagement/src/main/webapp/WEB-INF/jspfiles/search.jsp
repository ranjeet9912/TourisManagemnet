






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<style type="text/css">
  		<%@include file="/css/search.css" %>
  		input[type=text]{
		  width: 40%;
		  padding: 12px 20px;
		  
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  margin-left: 25%;
		  box-sizing: border-box;
		}
		input[type=submit] {
		  width: 8%;
		  background-color: #4CAF50;
		  color: white;
		  padding: 10px 14px;
		  
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		
  		</style>
<body>
	
	<h2 style="color:blue"> Search For An Employee</h2>
	<hr>
	
    <form:form action="search1" method="post" modelAttribute="bean" class="example">
      <form:input path="fname" placeholder="Search.."/> &nbsp;&nbsp;
      <input type="submit" value="Search">
      </form:form>
    <br><br>
	<table class="w3-table-all w3-centered">
		<tr>
		<th>Employee Name</th>
		<th>Employee Email</th>
		<th>Employee Department</th>
		<th>Employee Address</th>

		</tr>

		<c:forEach var="tab" items= "${li }">
		<tr>
		<td>  ${ tab.fname } </td>
		<td>${ tab.femail }  </td>
		<td> ${ tab.fdept } </td>
		<td> ${ tab.faddress } </td>
		</tr>
		
		</c:forEach>

	</table>




	<h2>${msg1 }</h2>

</body>
</html>