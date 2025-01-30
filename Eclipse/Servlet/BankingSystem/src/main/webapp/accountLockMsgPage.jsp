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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body
	class="bg-light d-flex justify-content-center align-items-center flex-column gap-3 vh-100">

	<%
	// Retrieve user object from session
	User user = (User) session.getAttribute("loggedInUser");
	if (user == null) {
		// Redirect to login page if session expired
		response.sendRedirect("/BankingSystem/loginPage.jsp");
	} else {
	%>
	<div class="bg-white p-4 rounded shadow d-flex justify-content-center align-items-center flex-column gap-3"
		style="width: 100%; max-width: 400px;">
		<i class="bi bi-lock-fill " style="font-size: 3rem;"></i>
		<h4 class="text-center text-success">Your Account is Locked !! 👎</h4>
	</div>
	<a href="/BankingSystem/securityPage.jsp">Click for Security Page</a>
	<%
	}
	%>

</body>
</html>