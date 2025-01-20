<!DOCTYPE html>
<html lang="en">

<head>
<title>Fetch All Students</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body class="bg-light d-flex flex-column min-vh-100">

	<p class="text-center mt-3">
		<a href="/StudentManagement/index.jsp">Return to Home</a>
	</p>
	<!-- Main Content -->
	<main class="container my-4 flex-grow-1">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-header bg-primary text-white text-center">
						<h4>Fetched Student Information</h4>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table">
								<tbody>
									<tr>
										<td><strong>Student ID</strong></td>
										<td><%=request.getAttribute("id")%></td>
									</tr>
									<tr>
										<td><strong>Student Name</strong></td>
										<td><%=request.getAttribute("name")%></td>
									</tr>
									<tr>
										<td><strong>Student Age</strong></td>
										<td><%=request.getAttribute("age")%></td>
									</tr>
									<tr>
										<td><strong>Student Gender</strong></td>
										<td><%=request.getAttribute("gender")%></td>
									</tr>
									<tr>
										<td><strong>Student Email</strong></td>
										<td><%=request.getAttribute("email")%></td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>

</body>

</html>
