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
		<h1 class="">!! Student Management System !!</h1>
	</header>

	<!-- Main Content Section -->
	<main>
		<div class="container">
			<div class="row g-4">
				<!-- Add Student -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-person-plus-fill text-primary"
								style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">Add Student</h5>
							<p class="card-text">Register a new student into the system.</p>
							<a href="/StudentManagement/addStudent.jsp"
								class="btn btn-primary">Add Now</a>
						</div>
					</div>
				</div>
				<!-- View Student by ID -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-eye text-success" style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">View Student by ID</h5>
							<p class="card-text">Search and view a student using their
								ID.</p>
							<a href="/StudentManagement/searchStudentById.jsp"
								class="btn btn-success">View One</a>
						</div>
					</div>
				</div>
				<!-- View All Students -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-list-task text-info" style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">View All Students</h5>
							<p class="card-text">Access a list of all registered
								students.</p>
							<a href="/StudentManagement/fetchAllStudents"
								class="btn btn-info text-white">View Students</a>

						</div>
					</div>
				</div>
				<!-- Edit Student by ID -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-pencil-fill text-warning"
								style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">Edit Student by ID</h5>
							<p class="card-text">Update the details of a student by their
								ID.</p>
							<a href="/StudentManagement/editStudentById.jsp"
								class="btn btn-warning text-white">Edit One</a>
						</div>
					</div>
				</div>
				<!-- Delete Student by ID -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-trash-fill text-danger" style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">Delete Student by ID</h5>
							<p class="card-text">Remove a student record using their ID.</p>
							<a href="/StudentManagement/deleteStudentById.jsp"
								class="btn btn-danger">Delete One</a>
						</div>
					</div>
				</div>
				<!-- Delete All Students -->
				<div class="col-md-4">
					<div class="card shadow">
						<div class="card-body text-center">
							<i class="bi bi-trash-fill text-danger" style="font-size: 2rem;"></i>
							<h5 class="card-title mt-3">Delete All Students</h5>
							<p class="card-text">Remove all student record.</p>
							<a href="/StudentManagement/deleteAllStudent.jsp"
								class="btn btn-danger">Delete All</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</main>

	<!-- Footer -->
	<footer class="bg-primary text-white text-center py-3">
		<p class="mb-0">© 2025 Student Management System. All Rights
			Reserved. Made By Nilendra Patel with <i class="bi bi-heart-fill text-danger"></i></p>
	</footer>

	<!-- Bootstrap JS Bundle -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+ujzV1olTGTXZpDUaCM9j6N2eGE0j"
		crossorigin="anonymous"></script>
</body>

</html>
