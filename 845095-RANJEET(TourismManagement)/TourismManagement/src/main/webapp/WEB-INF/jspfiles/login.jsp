<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<head>
<style type="text/css"> <%@include file="/css/stylereg.css" %> </style>
</head>

<h2>Tourist Login Panel</h2>
<div class="container">
  <form:form action="logindata" method="post" modelAttribute="bean">
 
    <div class="row">
      <div class="col-25">
        <label for="lname">Your Email</label>
      </div>
      <div class="col-75">
       <form:input path="femail" type="email" placeholder="Your email.."/>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="lname">Enter Password</label>
      </div>
      <div class="col-75">
       <form:input path="fpass" type="password"  placeholder="Your password.."/>
      </div>
    </div>
      
    
    <div class="row">
      <input type="submit" value="Login">
    </div><br>
    <a class="abc" href="register1"> Not Registered? Click Here..</a>
  </form:form>
  <h3>${msg}</h3>
  
</div>
