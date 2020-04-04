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
 <center><a> Welcome  ${shdata.hemail}</a> </center>
  <a href="find">Search Tourist</a>
  <a href="hlogout1">Logout</a>
 </li>
</div>


 <h2 style="text-align: center;color:FF7503">Tour Guide List</h2>
	
<center>
<div style="padding-left:16px">
  
 <table>
		<tr>
			<th>Tour Guide. Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Address</th>
		</tr>
		<c:forEach var="tab" items="${hdata}">
		<tr>
		<td>${tab.hid}</td>
		<td>${tab.hname}</td>
		<td>${tab.hemail}</td>
		<td>${tab.hdept}</td>
		<td>${tab.haddress}</td>
		</tr>		
		</c:forEach>
	</table>
<br>
<h3> ${msg } </h3>

	
</div>
</center>