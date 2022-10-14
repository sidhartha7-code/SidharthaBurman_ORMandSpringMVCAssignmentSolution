<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Student</title>
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
		<h2> Save Customer</h2>
		<br>
		<form action="/CRM/customer/save" method="post">
			<input type="hidden" name="custId" value="${customer.id}">
			<div class="form-inline">
			<input type="text"  name="firstName" value="${customer.firstName}" placeholder="First Name" id="fname" class="form-control mb-4 col-4">			
			</div>
			<div class="form-inline">
			<input type="text"  name="lastName" value="${customer.lastName}" placeholder="Last Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="email" value="${customer.email}" placeholder="Email" class="form-control mb-4 col-4">
			</div>
			<br>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<br>
		<a href="/CRM/customer/list">Back to Customer List</a>
	
	</div>
</body>
</html>