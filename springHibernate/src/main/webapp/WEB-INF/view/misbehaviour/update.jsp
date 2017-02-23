<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
	<div class="container">
		<div class="jumbotron">
			<h1>Update Misbehaviour</h1>
		</div>
		<s:url var="action" value="/misbehaviours/saveupdate" />
		<sf:form method="post" action="${action}" modelAttribute="misbehaviour">
			<sf:hidden path="id" />
			
			<div class="form-group">
				<label for="title">Title</label>
				<sf:input path="title" class="form-control" placeholder="Title" />
				<sf:errors path="title" cssClass="title" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" class="form-control"
					placeholder="Description" />
				<sf:errors path="description" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="date">Date</label>
				<sf:input path="date" class="form-control" type="date"
					placeholder="Date" />
				<sf:errors path="date" cssClass="error" />
			</div>
			<label for="user">User</label>
			<sf:select path="user.id" class="form-control">
				<sf:options items="${users}" itemLabel="login" itemValue="id" />
			</sf:select>

			<sf:button>Update</sf:button>
		</sf:form>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2017 Miguel Marzo</p>
		</div>
	</footer>
</body>
</html>
