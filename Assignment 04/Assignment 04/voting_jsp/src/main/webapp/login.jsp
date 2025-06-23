<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>From login page</h1>
<jsp:useBean id="loginbeans" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="loginbeans" property="email" param="email"/>
	<jsp:setProperty name="loginbeans" property="password" param="password"/>
	
	<% loginbeans.loginStatus(); %>
	
	User has  <jsp:getProperty name="loginbeans" property="status"/>

</body>
</html>