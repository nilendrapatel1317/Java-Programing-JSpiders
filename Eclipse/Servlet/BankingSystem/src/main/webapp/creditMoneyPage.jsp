<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="d-flex gap-2 flex-column-reverse">

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
				<a class="navbar-brand" href="#">Banking System</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link"
							href="/BankingSystem/logoutPage.jsp">Log Out</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div
			class="bg-light d-flex justify-content-center align-items-center flex-column-reverse gap-3 mt-5">
			<div class="bg-white p-4 rounded shadow mt-5"
				style="width: 100%; max-width: 400px;">
				<h2 class="text-center text-primary mb-4">Credit Amount</h2>
				<form action="creditMoney" method="post">
					<div class="mb-3">
						<label for="id" class="form-label">Enter Amount</label> <input
							type="number" class="form-control" id="id" name="amount"
							placeholder="Enter amount value" required>
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary text-white">Submit</button>
					</div>
					<div class="d-flex justify-content-center gap-4 flex-wrap">
						<div class="row justify-content-center">
							<div class="col-md-12 mt-4">
								<a href="/BankingSystem/bankingPage.jsp">return to banking
									page</a>
							</div>
						</div>
					</div>
				</form>


			</div>

		</div>
	</div>

	<%
	}
	%>

</body>
</html>