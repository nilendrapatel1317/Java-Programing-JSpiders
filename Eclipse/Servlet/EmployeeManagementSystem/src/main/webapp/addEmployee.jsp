<html>
<head>
<title>Register Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body class="d-flex flex-column-reverse mt-4">
	<div class="d-flex justify-content-center align-items-center my-5">
		<div class="bg-white p-4 rounded shadow"
			style="width: 100%; max-width: 400px;">
			<h2 class="text-center text-primary mb-4">Add Employee</h2>
			<form action="addEmployee" method="post">
				<div class="mb-3">
					<label for="name" class="form-label">Name</label> <input
						type="text" class="form-control" id="name" name="name"
						placeholder="Enter your name" required>
				</div>

				<div class="mb-3">
					<label for="age" class="form-label">Age</label> <input
						type="number" class="form-control" id="age" name="age" min="1"
						max="100" required>

				</div>

				<div class="mb-3">
					<label for="gender" class="form-label">Gender</label> <select
						class="form-select" id="gender" name="gender" required>
						<option value="" disabled selected>Select your gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" id="email" name="email"
						placeholder="Enter your email" required>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-primary text-white">Add</button>
				</div>
			</form>
			<p class="text-center  mt-3">
				<a href="/EmployeeManagementSystem/index.jsp">Return to Home</a>
			</p>

		</div>
	</div>

</body>

</html>
