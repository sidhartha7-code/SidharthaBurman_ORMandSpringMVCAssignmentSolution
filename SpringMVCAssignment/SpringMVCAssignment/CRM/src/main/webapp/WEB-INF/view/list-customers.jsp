<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- Stylesheet (CSS) & JSP Tag
     Library -->
<!DOCTYPE html>
<html>
<head>
<title>Student List</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="bg-primary text-white"> 
			<center>
				CUSTOMER RELATIONSHIP MANAGEMENT
			</center>
		</h1>
		<br><br>
		<br><br>
		<a href="/CRM/customer/showFormForAdd" class="btn btn-primary btn-info mb-3">Add Customer</a>
		<table class="table table-striped">
			<thead class='bg-success text-white'>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customer}" var="customer">
					<tr>
					<td><c:out value="${customer.firstName}"></c:out></td>
					<td><c:out value="${customer.lastName}"></c:out></td>
					<td><c:out value="${customer.email}"></c:out></td>
					<td>
					<a href="/CRM/customer/showFormForUpdate?id=${customer.id}" class="btn btn-info btn-sm">Update</a>
					<a href="/CRM/customer/delete?id=${customer.id}" class="btn btn-danger btn-sm" onclick="if(!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>
					</td>
					</tr>
				</c:forEach>
				<!-- Tag lib For loop -->
			</tbody>
		</table>
	</div>
</body>
</html>