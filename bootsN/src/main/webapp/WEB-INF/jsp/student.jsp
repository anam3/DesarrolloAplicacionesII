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
					<li><a href="new-student">Manage Student</a></li>
					<li><a href="all-students">All Students</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode=='MODE_HOME_STUDENT'}">
		<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome manager to student</h1>
		</div>	
	</div>
	</c:when>	
	</c:choose>
	
	<c:choose>

	<c:when test="${mode=='MODE_STUDENTS' }">
	<div class="container text-center" id="studentDiv">
		<h3>My Students</h3>
		<hr/>
		<div class="table-reposive">
			<table class="table table-stiped table-bordered">
				<thead>
					<tr>
						<td>Id</td>
						<td>Name</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Date</td>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${students}">
						<tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.first}</td>
							<td>${student.last}</td>
							<td><fmt:formatDate pattern="dd-mm-yyyy" value="${student.dateNac}"/></td>
							<td><a href="update-student?id=${student.id}">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-student?id=${student.id}">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</c:when>
		
	
	<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
		<div class="container text-center">
			<h3>Manager Student</h3>
			<hr/>
			<form class="form-horizontal" method="POST" action="save-student">
				<input type="hidden" name="id" value="${student.id}"/>
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${student.name}"
						name="name"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">First Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${student.first}" 
						name="first"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Last Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${student.last}" 
						name="last"/>
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
