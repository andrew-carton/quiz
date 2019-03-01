<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
<title>Register Page</title>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/common.css">
</head>

<body>

	<form:form action="${pageContext.request.contextPath}/registerUser">
	
		<c:if test="${param.error !=null}">
			<i class="failed">Sorry! Username taken or you entered an invalid username/password</i>
		</c:if>
		<p>
			Username: <input type="text" name="username" />		
		</p>
		
		<p>
			Password: <input type="password" name="password" />		
		</p>
		
		<input type="submit" value="Register" />
	</form:form>
	
</body>
</html>