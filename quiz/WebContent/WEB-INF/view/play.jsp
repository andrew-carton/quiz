<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage activeNavItem="play">
    
    <jsp:body>
    	<div class="myborder">
    		<p>Hello ${user}! Your current score is ${score}.</p>
    		<p>
		    	<c:if test="${correct == true}">
					You are correct!
				</c:if>
				<c:if test="${correct == false}">
					You are incorrect!
				</c:if>
		    	<c:if test="${answer!= null}">
					Answer is ${answer}
				</c:if>
        	</p>
        	<p>Question: ${question} </p>
        
        
	         <form:form action="${pageContext.request.contextPath}/play">
				<p>Answer: <input type="text" name="answer" /></p>
				<input name="questionid" type="hidden" value=${questionid} /> 
				<input type="submit" value="Submit" />
		</form:form>
	</div>
    </jsp:body>
</t:genericpage>