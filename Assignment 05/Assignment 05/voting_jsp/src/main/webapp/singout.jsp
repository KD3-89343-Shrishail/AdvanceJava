<%@page import="jakarta.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	Thank You , <jsp:getProperty name="lb" property="email"/>

 <% session.invalidate(); %>
	<%-- <jsp:setProperty property="email" name="lb" value=""/>
	<jsp:setProperty property="passwd" name="lb" value=""/>
	<jsp:setProperty property="user" name="lb" value=""/>
	 --%>
		<br>
	
	<a href="index.jsp">Sign In Again</a> 
	 
	
</body>
</html>