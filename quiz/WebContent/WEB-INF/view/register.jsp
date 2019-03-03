<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage activeNavItem="register">

	<jsp:body>
		<div class="myborder">
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
			</div>
		    </jsp:body>
		   
</t:genericpage>
