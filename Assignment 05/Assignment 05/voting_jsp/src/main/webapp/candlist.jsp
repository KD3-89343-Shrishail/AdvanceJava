<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidates</title>
</head>
<body>
	<h3>Candidate List</h3>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="email"/>
	<hr/>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean"/>
	${clb.fetchCandidates()}
	
		<c:choose>
		<c:when test="${sessionScope.lb.user.status}">
			<h3>Congratulations!</h3>
			<p>Your already voted !.</p>
			 <a href="singout.jsp">Sign Out</a> 
	
		</c:when>
		<c:otherwise>

	
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${clb.candidateList}">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>	
		</c:forEach>
		<input type="submit" value="Vote"/>
	</form>
		</c:otherwise>
	</c:choose>

</body>
</html>
