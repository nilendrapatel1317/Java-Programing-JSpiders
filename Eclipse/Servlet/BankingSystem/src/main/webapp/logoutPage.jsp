<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Logout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Are you sure you want to log out?</h1>
		<div class="d-flex justify-content-center gap-4">
			<div class="d-flex justify-content-center gap-4">
				<a href="/BankingSystem/LogoutServlet" class="btn btn-danger btn-lg">Yes,
					Log Out</a> <a href="/BankingSystem/homePage.jsp"
					class="btn btn-secondary btn-lg">No, Stay Logged In</a>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>
