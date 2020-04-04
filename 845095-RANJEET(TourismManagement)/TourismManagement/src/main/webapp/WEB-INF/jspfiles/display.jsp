<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<head>
<style type="text/css">
  		<%@include file="/css/home.css" %>
  		</style>
</head>
<div class="topnav">

 <li>
 <center><a> Welcome  ${sdata.femail}</a> </center>
  <a href="find">Search Tourist</a>
  <a href="logout1">Logout</a>
 </li>
</div>


 <h2 style="text-align: center;color:SlateBlue">Tourist List</h2>
	
<center>
<div style="padding-left:16px">
  
 <table>
		<tr>
			<th>Tourist Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Address</th>
		</tr>
		<c:forEach var="tab" items="${data}">
		<tr>
		<td>${tab.fac_id}</td>
		<td>${tab.fname}</td>
		<td>${tab.femail}</td>
		<td>${tab.fdept}</td>
		<td>${tab.faddress}</td>
		</tr>		
		</c:forEach>
	</table>
<br>
<h3> ${msg } </h3>

	
</div>
</center>