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
	Account account = (Account) session.getAttribute("loggedInUserAccount");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
	<%
	if (!account.isAcc_lock()) {
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
		<h1 class="text-center mb-4">Banking Features</h1>
		<div class="row justify-content-center">
			<div class="col-md-10 mt-5">
				<div class="d-flex justify-content-center gap-5">
					<a
						href="/BankingSystem/verifySecurityPin.jsp?operation=checkBalance"
						class="btn btn-info btn-lg text-white">Check Balance</a> <a
						href="/BankingSystem/verifySecurityPin.jsp?operation=viewAccount"
						class="btn btn-secondary btn-lg">View Account Details</a> <a
						href="/BankingSystem/verifySecurityPin.jsp?operation=debitMoney"
						class="btn btn-danger btn-lg">Debit Money</a> <a
						href="/BankingSystem/verifySecurityPin.jsp?operation=creditMoney"
						class="btn btn-success btn-lg">Credit Money</a> <a
						href="/BankingSystem/verifySecurityPin.jsp?operation=transferMoney"
						class="btn btn-warning btn-lg text-white">Transfer Money</a>
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
	} else {
	%>
	<div
		class="d-flex justify-content-center align-items-center flex-column gap-4 vh-100">
		<h1 style="font-size: 5vw;margin-bottom: 50px">Account is Locked</h1>
		<a href="/BankingSystem/verifySecurityPin.jsp?operation=unLockAccount"
			class="btn btn-info text-white">Click to unlock your
			account</a>
		<a href="/BankingSystem/homePage.jsp"
			class="btn btn-primary text-white">return to homepage</a>
	</div>
	<%
	}
	%>

	<%
	}
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-IQsoLXlQ2vG8ht9FyQt1wYG2KE3eTMyWxPtIb8UUepoe8XBzJCOUxBalPdHWXl4u"
		crossorigin="anonymous"></script>
</body>
</html>
