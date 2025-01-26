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
<body class="bg-light">

	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	Account account = (Account) session.getAttribute("loggedInUserAccount");
	
	System.out.println(user);
	System.out.println(account);
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
		<h1 class="text-center mb-4">
			Hello,
			<%=user.getName()%></h1>
		<div class="row justify-content-center">
			<div class="d-flex align-items-center justify-content-center flex-column mt-4">
				<div class="bg-white p-4 rounded shadow w-25">
					<h4 class="text-center text-success mt-3">
						Balance: Rs
						<span class="fw-bold" style="text-decoration: underline;"><%=account.getBalance()%></span>
					</h4>
				</div>
				<div class="my-3 text-center w-100">
					<a href="/BankingSystem/bankingPage.jsp">return to banking app</a>
				</div>
			</div>
		</div>
	</div>


	<%
	}
	%>

</body>
</html>