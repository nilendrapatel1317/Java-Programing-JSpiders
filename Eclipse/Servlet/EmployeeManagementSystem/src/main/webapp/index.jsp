<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome - Homepage</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<style>
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	margin: 0;
}

header {
	flex-shrink: 0;
}

main {
	flex-grow: 1;
	display: flex;
	align-items: center;
	justify-content: center;
}

footer {
	flex-shrink: 0;
}
</style>
</head>

<body class="">

	<!-- Header -->
	<header class="bg-primary text-white text-center py-3">
		<h1 class="">!! Employee Management System !!</h1>
	</header>

	<!-- Main Content Section -->
	<main>
		<div class="container">
			<div class="row d-flex justify-content-center align-items-center g-4 ">
				<!-- Add Student -->
				<div class="col-md-3">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-person-plus-fill text-primary"
								style="font-size: 2rem;"></i>
							<h5 class="card-title my-3">Add Employee</h5>
							<a href="/EmployeeManagementSystem/addEmployee.jsp"
								class="btn btn-primary mb-3">Add Now</a>
						</div>
					</div>
				</div>

				<!-- View All Students -->
				<div class="col-md-3">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-list-task text-info" style="font-size: 2rem;"></i>
							<h5 class="card-title my-3">View All Employees</h5>
							<a href="/EmployeeManagementSystem/fetchAllEmployees"
								class="btn btn-info text-white mb-3">View Employees</a>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- Footer -->
	<footer class="bg-primary text-white text-center py-3">
		<p class="mb-0">
			© 2025 Employee Management System. All Rights Reserved. Made By
			Nilendra Patel with <i class="bi bi-heart-fill text-danger"></i>
		</p>
	</footer>

	<!-- Bootstrap JS Bundle -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+ujzV1olTGTXZpDUaCM9j6N2eGE0j"
		crossorigin="anonymous"></script>
</body>

</html>
