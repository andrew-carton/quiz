<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="activeNavItem" required="true"%>

<!DOCTYPE html>

<html>

<head>
<title>Login Page</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/common.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">



<script>
window.onload=function() {
	let mainNav = document.getElementById('js-menu');
	let navBarToggle = document.getElementById('js-navbar-toggle');

	navBarToggle.addEventListener('click', function () {
    	mainNav.classList.toggle('active');
	});
}

</script>
</head>

<body>
	<p style="text-align: center;"><img width="10%" height="10%" src="${pageContext.request.contextPath}/images/riddle.png" /></p>
	<header>
		<nav class="navbar" id="navbar">
			<span class="navbar-toggle" id="js-navbar-toggle">
            	<i class="fas fa-bars"></i>
        	</span>
			<ul class="navlist" id="js-menu">
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

