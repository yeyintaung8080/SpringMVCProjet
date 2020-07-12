<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="./inc/commontaglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
<strong>Update Customer Info</strong>

<form:form action="updateCustomer" modelAttribute="customer" method="POST">

	<!-- need to associate this data with customer id -->
		<form:hidden path="id"/>
		
	<table>
		<tr>
			<td>First Name</td>
			<td><form:input path="fname" />***
				<form:errors path="fname"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Last Name</td>
			<td><form:input path="lname" />***
				<form:errors path="lname"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Age</td>
			<td><form:input path="age" />***
				<form:errors path="age"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Email</td>
			<td><form:input path="email" />***
				<form:errors path="email"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Address</td>
			<td><form:input path="address" />***
				<form:errors path="address"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<td colspan="2"><input type="submit" value="Update"/>
			</td>
		

		</tr>
	</table>
</form:form>


</body>
</html>