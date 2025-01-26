<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="BankingSystem.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Account</title>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Banking System</a>
		</div>
	</nav>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Open Account</h1>
		<form action="/BankingSystem/openAccount" method="post" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="initialAmount" class="form-label">Enter Initial
					Amount:</label> <input type="number" class="form-control border-2"
					id="initialAmount" name="initialAmount" required>
			</div>
			<div class="mb-3">
				<label for="securityPin" class="form-label">Enter Security
					Pin:</label> <input type="number" class="form-control border-2"
					id="securityPin" name="securityPin" required>
			</div>
			<button type="submit" class="btn btn-success btn-lg w-100">Open
				Account</button>
		</form>
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
