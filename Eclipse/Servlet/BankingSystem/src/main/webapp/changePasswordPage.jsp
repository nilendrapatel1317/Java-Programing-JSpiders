<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="BankingSystem.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="d-flex flex-column-reverse">
	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>

	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="/BankingSystem/index.jsp">Banking
					System</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link"
							href="/BankingSystem/logoutPage.jsp">Log Out</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="d-flex align-items-center justify-content-center">
			<div
				class="d-flex flex-column align-items-center rounded shadow w-50 py-5 gap-3">
				<h1 class="text-center">Change Password</h1>
				<form action="changePassword" method="post" class="mt-4 w-50">
					<div class="mb-3">
						<label for="currentPassword" class="form-label">Enter
							Current Password</label> <input type="password" class="form-control"
							id="currentPassword" name="currentPassword" required>
					</div>
					<div class="mb-3">
						<label for="newPassword" class="form-label">Enter New
							Password</label> <input type="password" class="form-control"
							id="newPassword" name="newPassword" required>
					</div>
					<div class="mb-3">
						<label for="confirmPassword" class="form-label">Confirm
							New Password</label> <input type="password" class="form-control"
							id="confirmPassword" name="confirmPassword" required>
					</div>
					<div class="d-flex gap-3">
						<button type="submit" class="btn btn-primary w-50">Change
							Password</button>
						<a href="/BankingSystem/securityPage.jsp" class="btn btn-danger w-50">Cancel</a>
					</div>
				</form>
			</div>
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
