<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Isave candidate</title>
</head>
<body>
<h3>Candidate registration </h3>
<jsp:useBean id="ucb" class="com.sunbeam.beans.UpdateCandidateBean"/>
<jsp:setProperty  name="ucb" property="*"/>

${ucb.addCandidate()}
	<c:choose>
		<c:when test="${ucb.savestatus}">
			<p>candidate Added  successfully.</p>
			<a href="result.jsp">Result page</a>
		</c:when>
		<c:otherwise>
			<p>candidate Registration is failed.</p>
			<a href="addcand.jsp">candidate add Again</a> | 
		</c:otherwise>
	</c:choose>


</body>
</html>