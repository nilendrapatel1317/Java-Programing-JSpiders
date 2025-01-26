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
<body style="background-color: #f8f9fa;" class="d-flex align-items-center justify-content-center vh-100 m-0">
	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
	<div class="confirm-container shadow text-center rounded p-4 bg-white"
		style="max-width: 400px; width: 100%;">
		<h2 class="mb-4">Are you sure you want to log out?</h2>
		<div class="d-flex justify-content-center gap-3">
			<a href="/BankingSystem/LogoutServlet" class="btn btn-danger">Yes,
				Log Out</a> <a href="/BankingSystem/homePage.jsp"
				class="btn btn-secondary">No, Stay Logged In</a>
		</div>
	</div>
	<%
	}
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-IQsoLXlQ2vG8ht9FyQt1wYG2KE3eTMyWxPtIb8UUepoe8XBzJCOUxBalPdHWXl4u"
		crossorigin="anonymous"></script>
</body>
</html>
