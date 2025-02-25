
<%
String empId = request.getParameter("id");
String name = request.getParameter("name");
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String email = request.getParameter("email");
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
</head>

<body
	class="bg-light d-flex justify-content-center align-items-center min-vh-100">
	<div class="bg-white p-4 rounded shadow"
		style="width: 100%; max-width: 400px; ">
		<h2 class="text-center text-primary mb-4">Edit Employee</h2>
		<form action="updateEmployee" method="post">
			<!-- Employee ID (Read-only) -->
			<div class="mb-3">
				<label for="id" class="form-label">ID <span
					class="text-danger">[read-only]</span></label> <input type="text"
					class="form-control text-secondary" id="id" name="id" value="<%=empId%>"
					readonly>
			</div>

			<!-- Name -->
			<div class="mb-3">
				<label for="name" class="form-label">Name</label> <input type="text"
					class="form-control" id="name" name="name"
					placeholder="Enter your name" value="<%=name%>">
			</div>

			<!-- Age -->
			<div class="mb-3">
				<label for="age" class="form-label">Age</label> <input type="number"
					class="form-control" id="age" name="age"
					placeholder="Enter your age" value="<%=age%>">
			</div>

			<!-- Gender -->
			<div class="mb-3">
				<label for="gender" class="form-label">Gender</label> <select
					class="form-select" id="gender" name="gender">
					<option value="male" <%="male".equals(gender) ? "selected" : ""%>>Male</option>
					<option value="female"
						<%="female".equals(gender) ? "selected" : ""%>>Female</option>
					<option value="other"
						<%="other".equals(gender) ? "selected" : ""%>>Other</option>
				</select>
			</div>

			<!-- Email (Read-only) -->
			<div class="mb-3">
				<label for="email" class="form-label">Email <span
					class="text-danger">[read-only]</span></label> <input type="email" 
					class="form-control text-secondary" id="email" name="email" value="<%=email%>"
					readonly>
			</div>

			<!-- Submit Button -->
			<div class="d-flex gap-3">
				<button type="submit" class="btn btn-primary text-white w-50">Save
					Changes</button>
				<a href="/EmployeeManagementSystem/fetchAllEmployees"
					class="btn btn-danger text-white w-50">Cancel</a>
			</div>
		</form>
	</div>
</body>
</html>
