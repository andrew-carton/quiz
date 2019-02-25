<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
<title>Login Page</title>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/common.css">
</head>

<body>

	<form:form action="${pageContext.request.contextPath}/authenticateUser">
	
		<c:if test="${param.error !=null}">
			<i class="failed">Sorry!  You entered an invalid username/password</i>
		</c:if>
		<p>
			User name: <input type="text" name="username" />		
		</p>
		
		<p>
			Password: <input type="text" name="password" />		
		</p>
		
		<input type="submit" value="Login" />
	</form:form>
	
</body>
</html>