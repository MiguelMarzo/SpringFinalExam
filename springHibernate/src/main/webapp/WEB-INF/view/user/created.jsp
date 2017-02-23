<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="jumbotron">
			<h1>User created</h1>
		</div>
		<div class="alert alert-success" role="alert">The following user
			has been created successfully</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Description</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td>${user.description}</td>
					<td>${user.password}</td>
				</tr>
			</tbody>
		</table>
	</tiles:putAttribute>
</tiles:insertDefinition>