<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BankingSystem.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User Details</title>
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
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/profilePage.jsp">Profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/BankingSystem/logout.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div class="container mt-4">
		<h1 class="text-center mb-4">Edit User Details</h1>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form action="updateUserDetails" method="post"
					class="p-4 border rounded bg-light shadow">
					<div class="mb-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" class="form-control" id="name" name="name"
							value="<%=user.getName()%>" required>
					</div>
					<div class="mb-3">
						<label for="age" class="form-label">Age</label> <input
							type="number" class="form-control" id="age" name="age"
							value="<%=user.getAge()%>" required>
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">Gender</label> <select
							class="form-select" id="gender" name="gender" required>
							<option value="Male"
								<%="Male".equals(user.getGender()) ? "selected" : ""%>>Male</option>
							<option value="Female"
								<%="Female".equals(user.getGender()) ? "selected" : ""%>>Female</option>
							<option value="Other"
								<%="Other".equals(user.getGender()) ? "selected" : ""%>>Other</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="city" class="form-label">City</label> <input
							type="text" class="form-control" id="city" name="city"
							value="<%=user.getCity()%>" required>
					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">Phone</label> <input
							type="tel" class="form-control" id="phone" name="phone"
							value="<%=user.getPhone()%>" required>
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Save
							Changes</button>
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
