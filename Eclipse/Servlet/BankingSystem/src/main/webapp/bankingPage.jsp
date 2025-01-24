<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking Features</title>
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
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/logoutPage.jsp">Log Out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Banking Features</h1>
		<div class="row justify-content-center">
			<div class="col-md-10 mt-5">
				<div class="d-flex justify-content-center gap-5">
					<a href="/BankingSystem/checkBalancePage.jsp"
						class="btn btn-info btn-lg">Check Balance</a> <a
						href="/BankingSystem/accountDetailPage.jsp"
						class="btn btn-secondary btn-lg">View Account Details</a> <a
						href="/BankingSystem/debitMoneyPage.jsp"
						class="btn btn-danger btn-lg">Debit Money</a> <a
						href="/BankingSystem/creditMoneyPage.jsp"
						class="btn btn-success btn-lg">Credit Money</a> <a
						href="/BankingSystem/transferMoneyPage.jsp"
						class="btn btn-warning btn-lg">Transfer Money</a>
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
