<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">
		<div class="jumbotron">
			<h1>Users detail</h1>
			<p>See this user info</p>
		</div>

		<c:choose>
			<c:when test="${not empty user}">
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
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning" role="alert">A user with the
					id specified has not been found. Please, try again</div>
			</c:otherwise>
		</c:choose>
	</tiles:putAttribute>
</tiles:insertDefinition>