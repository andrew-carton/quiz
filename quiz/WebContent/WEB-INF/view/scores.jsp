<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage activeNavItem="play">
    
    <jsp:body>
    	<div class="myborder">
    	<p>Scores:</p>
    		<table>
    		<c:forEach items="${users}" var="element"> 
  				<tr>
    				<td>${element.username}</td>
    				<td>${element.score}</td>
  				</tr>
			</c:forEach>
		</table>
	</div>
    </jsp:body>
</t:genericpage>