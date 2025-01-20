<!DOCTYPE html>
<html>

<head>
<title>Edit Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body class="bg-light">
	<div class="d-flex justify-content-center align-items-center vh-100">
		<div class="bg-white p-4 rounded shadow"
			style="width: 100%; max-width: 400px;">
			<h2 class="text-center text-primary mb-4">Edit Student</h2>
			<form action="editStudent" method="post">

				<div class="mb-3">
					<label for="id" class="form-label">Student Id</label> <input
						type="number" class="form-control" id="id"
						placeholder="Enter student id" required>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-warning text-white">Edit</button>
				</div>
			</form>
			<p class="text-center  mt-3">
				<a href="/StudentManagement/index.jsp">Return to Home</a>
			</p>

		</div>
	</div>

</body>

</html>
