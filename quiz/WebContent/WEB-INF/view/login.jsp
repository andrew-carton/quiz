<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage activeNavItem="login">
    
    <jsp:body>
        <form:form action="${pageContext.request.contextPath}/authenticateUser">
	
		<c:if test="${param.error !=null}">
			<i class="failed">Sorry!  You entered an invalid username/password</i>
		</c:if>
		<p>
			Username: <input type="text" name="username" />		
		</p>
		
		<p>
			Password: <input type="password" name="password" />		
		</p>
		
		<input type="submit" value="Login" />
	</form:form>
    </jsp:body>
</t:genericpage>