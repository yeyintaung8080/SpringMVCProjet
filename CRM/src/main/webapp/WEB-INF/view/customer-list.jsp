<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="./inc/commontaglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Home Page</title>
</head>
<body>
	<security:authorize access="isAuthenticated()">
		<h3>WELCOME&nbsp;<security:authentication
				property="principal.username" />!</h3>
		<h3>
			Role:
			<security:authentication property="principal.authorities" />
		</h3>
	</security:authorize>

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<input type="button" value="Add Customer"
			onclick="window.location.href='${pageContext.request.contextPath}/manager/showFormForAdd'; return false;">
		</p>
	</security:authorize>

	
		<table border="1">
			<c:set var="counter" value="0"></c:set>
			
			<tr>
				<td colspan="6">
					<form:form method="GET" action="${pageContext.request.contextPath}/search">
						<input type="text" name="email" >[Search by Email]
						<input type="submit" value="Search">
						<input type="button" value="Show All"
			onclick="window.location.href='${pageContext.request.contextPath}/homepage'; return false;">
	   					
					</form:form>
				</td>
				<td colspan="1">
					<form:form method="POST" action="${pageContext.request.contextPath}/logout">
	   					<input type="submit" value="Logout">
					</form:form>
				</td>
			</tr>
			
		<c:if test="${empty customers}">
			No Customer Record Found.
		</c:if>
		<c:if test="${!empty customers}">
			<tr>
				<td>#</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
				<td>Email</td>
				<td>Address</td>
				<security:authorize access="hasRole('ADMIN')">
					<td>Action</td>
				</security:authorize>
			</tr>

			<c:forEach var="customer" items="${customers}">
			
			<security:authorize access="hasRole('ADMIN')">
			<c:url var="updateLink" value="/admin/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/admin/customerDelete">
						<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			</security:authorize>
				<c:set var="counter" value="${counter+1}"></c:set>
				<tr>
					<td>${counter}</td>

					<td>${customer.first_name}</td>

					<td>${customer.last_name}</td>

					<td>${customer.age}</td>
					
					<td>${customer.email}</td>

					<td>${customer.address}</td>
					
					<security:authorize access="hasRole('ADMIN')">
					<td>
						<a href="${updateLink}">Update</a>
						
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are You Sure To Delete This')))return false">Delete</a>
					</td>
					</security:authorize>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	
</body>
</html>