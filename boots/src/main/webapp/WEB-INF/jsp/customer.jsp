<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap sample| Home</title>
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="new-customer">Manage Customer</a></li>
					<li><a href="all-customers">All Customer</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode=='MODE_HOME_CUSTOMER'}">
		<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome manager to customer</h1>
		</div>	
	</div>
	</c:when>	
	</c:choose>
	
	<c:choose>
	<c:when test="${mode=='MODE_CUSTOMERS' }">
	<div class="container text-center" id="customersDiv">
		<h3>My Customers</h3>
		<hr/>
		<div class="table-reposive">
			<table class="table table-stiped table-bordered">
				<thead>
					<tr>
						<td>Id</td>
						<td>Name</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Phone</td>
						<td>Email</td>
						<td>RFC</td>
						<td>Age</td>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.name}</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.phone}</td>
							<td>${customer.email}</td>
							<td>${customer.rfc}</td>
							<td>${customer.age}</td>
							<td><a href="update-customer?id=${customer.id}">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-customer?id=${customer.id}">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</c:when>
	
	<c:when test="${mode=='MODE_NEW_CUSTOMER' || mode=='MODE_UPDATE_CUSTOMER'}">
		<div class="container text-center">
			<h3>Manager Customer</h3>
			<hr/>
			<form class="form-horizontal" method="POST" action="save-customer">
				<input type="hidden" name="id" value="${customer.id}"/>
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.name}"
						name="name"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">First Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.firstName}" 
						name="firstName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Last Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.lastName}" 
						name="lastName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Phone</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.phone}" 
						name="phone"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Email</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.email}" 
						name="email"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">RFC</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.rfc}" 
						name="rfc"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Age</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.age}" 
						name="age"/>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Save">
				</div>
				
			</form>
		</div>
	</c:when>
	
	</c:choose>
	
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>

</body>
</html>
	