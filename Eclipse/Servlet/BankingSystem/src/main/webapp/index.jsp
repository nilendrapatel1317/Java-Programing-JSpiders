<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking System Project</title>
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
	if (user != null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/homePage.jsp");
	} else {
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Banking System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/registerPage.jsp">Register</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/loginPage.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/exit.jsp">Exit</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container mt-5">
		<h1 class="text-center mb-4">Welcome to the Banking System</h1>
		<p class="text-center lead">Your one-stop solution for all your
			banking needs. Register, log in, or exit using the options below.</p>

		<!-- Buttons Section -->
		<div class="d-flex justify-content-center gap-3 mt-4">
			<a href="/BankingSystem/registerPage.jsp"
				class="btn btn-success btn-lg">Register</a> <a
				href="/BankingSystem/loginPage.jsp" class="btn btn-primary btn-lg">Login</a>
			<a href="/BankingSystem/exit.jsp" class="btn btn-danger btn-lg">Exit</a>
		</div>
	</div>


	<%
	}
	%>
	<script src="/BankingSystem/script.js"></script>
</body>
</html>
