<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
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
		long accountNumber = user.getAccountNumber();
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Banking System</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/logoutPage.jsp">Log Out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<h1 class="text-center mb-4 text-capitalize">
			Welcome,
			<%=user.getEmail()%>
			!
		</h1>
		<div class="row justify-content-center">
			<%
			if (accountNumber == 0) {
			%>
			<div class="col-md-6 text-center">
				<a href="/BankingSystem/openAccountPage.jsp"
					class="btn btn-primary btn-lg mb-3">Open a New Bank Account</a><br>
			</div>
			<%
			} else {
			%>
			<div class="col-md-6 mt-5">
				<div class="d-flex justify-content-center gap-5">
					<a href="/BankingSystem/profilePage.jsp"
						class="btn btn-success btn-lg">Profile Feature</a> <a
						href="/BankingSystem/bankingPage.jsp"
						class="btn btn-primary btn-lg">Banking Feature</a> <a
						href="/BankingSystem/securityPage.jsp"
						class="btn btn-warning text-white btn-lg">Security</a>
				</div>
			</div>
			<%
			}
			%>
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
