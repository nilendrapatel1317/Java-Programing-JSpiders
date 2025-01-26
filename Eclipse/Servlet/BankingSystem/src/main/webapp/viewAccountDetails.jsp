<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
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
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="d-flex justify-content-center gap-4 flex-wrap">
					<div class="row justify-content-center">
						<div class="col-md-12 mb-5">
							<a href="/BankingSystem/bankingPage.jsp">return to banking
								page</a>
						</div>
					</div>
				</div>
				<div class="card shadow">
					<div class="card-header bg-primary text-white text-center">
						<h3>User Account Details</h3>
					</div>
					<div class="card-body">
						<table class="table">
							<tbody>
								<tr>
									<th style="width: 50%;">User ID</th>
									<td style="width: 50%;"><%=user.getId()%></td>
								</tr>
								<tr>
									<th style="width: 50%;">User Name</th>
									<td style="width: 50%;"><%=user.getName()%></td>
								</tr>
								<tr>
									<th style="width: 50%;">Account Number</th>
									<td style="width: 50%;"><%=account.getAccountNumber()%></td>
								</tr>
								<tr>
									<th style="width: 50%;">Account Balance</th>
									<td style="width: 50%;">Rs <%=account.getBalance()%></td>
								</tr>
								<tr>
									<th style="width: 50%;">Account Lock Status</th>
									<td style="width: 50%;"><%=account.isAcc_lock()%></td>
								</tr>
							</tbody>
						</table>
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
