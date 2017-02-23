<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Users app</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<s:url value="/misbehaviours" />"
					title="<s:message code="navbar.assignments"></s:message>"><s:message
							code="navbar.assignments"></s:message></a></li>
				<li><a href="<s:url value="/users/" />"
					title="<s:message code="navbar.users"></s:message>"><s:message
							code="navbar.users"></s:message></a></li>
				<li><a href="<s:url value="/users/new" />"
					title="<s:message code="navbar.newUser"></s:message>"><s:message
							code="navbar.newUser"></s:message></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="true"><s:message
							code="navbar.language"></s:message> <span class="caret"></span> </a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="?locale=en"><img src="blank.gif"
								class="flag flag-gb"
								alt="<s:message code="english"></s:message>" /> <s:message
									code="english"></s:message></a></li>
						<li><a href="?locale=es"><img src="blank.gif"
								class="flag flag-es"
								alt="<s:message code="spanish"></s:message>" /> <s:message
									code="spanish"></s:message></a></li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
