<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Features</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.container {
	width: 90%;
}

.btn-lg {
	width: 250px; /* Adjust the width of the buttons */
}
</style>
</head>
<body>
	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	Account account = (Account) session.getAttribute("loggedInUserAccount");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
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
	<div class="container mt-5">
		<h1 class="text-center mb-4">Security Features</h1>
		<div class="row justify-content-center">
			<div class="col-md-12 mt-5">
				<div class="d-flex justify-content-center gap-4 flex-wrap">
					<a href="/BankingSystem/changePasswordPage.jsp"
						class="btn btn-warning btn-lg text-white">Change Login
						Password</a> <a href="/BankingSystem/changePinPage.jsp"
						class="btn btn-success btn-lg">Change Security Pin</a><a
						href="/BankingSystem/verifyProfilePassword.jsp"
						class="btn btn-danger btn-lg">Delete Your Profile ⚠️</a>

					<%
					if (account.isAcc_lock()) {
					%>
					<a
						href="/BankingSystem/verifySecurityPin.jsp?operation=unLockAccount"
						class="btn btn-info btn-lg text-white">Account Unlocking</a>

					<%
					} else {
					%>
					<a
						href="/BankingSystem/verifySecurityPin.jsp?operation=lockAccount"
						class="btn btn-danger btn-lg">Account Locking ⚠️</a>
					<%
					}
					%>
				</div>
				<div class="d-flex justify-content-center gap-4 flex-wrap">
					<div class="row justify-content-center">
						<div class="col-md-12 mt-5">
							<a href="/BankingSystem/homePage.jsp">return to homepage</a>
						</div>
					</div>
				</div>
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
