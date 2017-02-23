<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Misbehaviours</title>

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Misbehaviours app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<s:url value="/misbehaviours/" />"
						title="View Misbehaviours">View Misbehaviours</a></li>
					<li><a href="<s:url value="/users/" />" title="View users">View
							users</a></li>
					<li><a href="<s:url value="/misbehaviours/new" />"
						title="New Misbehaviour">New Misbehaviour</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="jumbotron">
		<h1>Misbehaviour detail</h1>
		<p>See this Misbehaviour info</p>
	</div>

	<c:choose>
		<c:when test="${not empty misbehaviour}">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Description</th>
						<th>Date</th>
						<th>User</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${misbehaviour.id}</td>
						<td>${misbehaviour.title}</td>
						<td>${misbehaviour.description}</td>
						<td>${misbehaviour.date}</td>
						<td>${misbehaviour.user.login}</td>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert">A misbehaviour
				with the id specified has not been found. Please, try again</div>
		</c:otherwise>
	</c:choose>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2017 Miguel Marzo</p>
		</div>
	</footer>
</body>
</html>