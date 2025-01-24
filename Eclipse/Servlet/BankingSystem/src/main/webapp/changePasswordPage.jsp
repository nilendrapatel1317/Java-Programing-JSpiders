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
<body>
	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
	<div class="mt-5 d-flex flex-column align-items-center gap-3">
		<h1 class="text-center">Change Password</h1>
		<form action="changePassword" method="post" class="mt-4 w-25">
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
				<label for="confirmPassword" class="form-label">Confirm New
					Password</label> <input type="password" class="form-control"
					id="confirmPassword" name="confirmPassword" required>
			</div>
			<button type="submit" class="btn btn-primary">Change
				Password</button>
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
