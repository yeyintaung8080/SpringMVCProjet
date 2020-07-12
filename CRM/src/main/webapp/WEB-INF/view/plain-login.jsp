
<%@ include file="./inc/commontaglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Custom Login Page</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
		<h1>My Custom Login Page</h1>
	
		<!-- Show Error -->
		<c:if test="${param.error !=null}">
			<i>Sorry, you added invalid username/password.</i>
		</c:if>
		<table>
			<tbody>
				<tr>
					<td>User Name:</td>
					<td>
						<input type="text" name="username">
					</td>
				</tr>
			
				<tr>
					<td>Password:</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				
				<tr>
					 
					<td colspan="2">
						<input type="submit" value="Login">
					</td>
				</tr>
			</tbody>
			
		</table>
		
	</form:form>
</body>
</html>