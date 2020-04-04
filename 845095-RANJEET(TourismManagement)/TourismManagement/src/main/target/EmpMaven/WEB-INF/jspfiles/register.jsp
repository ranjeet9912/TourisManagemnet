<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<html>
<head>
</head>
<body>
	<h1>Add Faculty Page</h1>
	<br>
	<form:form action="save" method="post" modelAttribute="bean">
	Enter Name: <form:input path="fname" /><br/><br/>
	Enter Email: <form:input path="femail" type="email"/>
		<br /><br/>
		Enter Password: <form:input path="fpass" type="password" />
		<br /><br/>
		Select Gender: <form:radiobutton path="gender" value="Male" />Male&nbsp;
					   <form:radiobutton path="gender" value="Female" />Female&nbsp;<br /><br/>
		
		Departement:<form:select path="fdept">
		 	<form:option value=""> -- select an option -- </form:option>	
			<form:option value="CSE">CSE</form:option>
			<form:option value="IT">IT</form:option>
			<form:option value="ME">ME</form:option>
			<form:option value="ECE">ECE</form:option>
			</form:select>
		<br /><br/>

		Date of Birth: <form:input path="fdob" type="date" />
		<br/><br/>
		Address: <form:input path="faddress" type="text"/>
		<br/><br/>

		<input type="submit" value="Save It.">


	</form:form>

	<br>
	<h2>${msg }</h2>

</body>
</html>