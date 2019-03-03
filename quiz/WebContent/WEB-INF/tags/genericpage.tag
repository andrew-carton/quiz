<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="activeNavItem" required="true"%>

<!DOCTYPE html>

<html>

<head>
<title>Login Page</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/common.css">
</head>

<body>
	<p style="text-align: center;"><img width="10%" height="10%" src="${pageContext.request.contextPath}/images/riddle.png" /></p>
	<header>
		<nav class="navbar">
			<ul class="navlist">
				<c:choose>
					<c:when test="${activeNavItem == 'login'}">
						<li class="navitem"><a class="active" href="${pageContext.request.contextPath}/login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li class="navitem"><a href="${pageContext.request.contextPath}/login">Login</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${activeNavItem == 'register'}">
						<li class="navitem"><a class="active" href="${pageContext.request.contextPath}/register">Register</a></li>
					</c:when>
					<c:otherwise>
						<li class="navitem"><a href="${pageContext.request.contextPath}/register">Register</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${activeNavItem == 'scores'}">
						<li class="navitem"><a class="active" href="${pageContext.request.contextPath}/scores">Scores</a></li>
					</c:when>
					<c:otherwise>
						<li class="navitem"><a href="${pageContext.request.contextPath}/scores">Scores</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${activeNavItem == 'play'}">
						<li class="navitem"><a class="active" href="${pageContext.request.contextPath}/play">Play</a></li>
					</c:when>
					<c:otherwise>
						<li class="navitem"><a href="${pageContext.request.contextPath}/play">Play</a></li>
					</c:otherwise>
				</c:choose>
				<li class="navitem"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<jsp:doBody />


</body>
</html>

