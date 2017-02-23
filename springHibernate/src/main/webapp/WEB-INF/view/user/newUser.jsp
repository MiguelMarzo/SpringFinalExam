<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="jumbotron">
			<h1>New user</h1>
			<p>See this user info</p>
		</div>
		<c:url var="post_user" value="/users/new" />
		<sf:form method="post" modelAttribute="user" action="${post_user}">
			<div class="form-group">
				<label for="login">Login</label>
				<sf:input path="login" class="form-control" placeholder="Login" />
				<sf:errors path="login" cssClass="error" />

			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<sf:input path="password" class="form-control" type="password"
					placeholder="Password" />
				<sf:errors path="password" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" class="form-control"
					placeholder="Description" />
				<sf:errors path="description" cssClass="error" />
			</div>
			<sf:button class="btn btn-primary pull-right">Create</sf:button>
		</sf:form>
	</tiles:putAttribute>
	<tiles:putAttribute name="pageScripts">
		<script src="<c:url value="/resources/js/validateUserForm.js" />"></script>
	</tiles:putAttribute>
</tiles:insertDefinition>