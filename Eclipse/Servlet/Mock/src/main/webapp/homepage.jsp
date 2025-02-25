<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mock.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// Retrieve user object from session
	Users user = (Users) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/Mock/login.jsp");
	} else {
	%>
	
	<h1>Home Page</h1>
	<a href="logout">Log Out</a>
	<%
	}
	%>
</body>
</html>