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


	<p class="text-center  mt-3">
		<a href="/StudentManagement/index.jsp">Return to Home</a>
	</p>
	<!-- Main Content -->
	<main class="container my-4 flex-grow-1">
		<h2 class="text-center text-primary mb-4">Student List</h2>
		<div class="table-responsive">
			<table
				class="table table-bordered table-striped text-center align-middle">
				<thead class="table-primary">
					<tr>
						<th>Student ID</th>
						<th>Student Name</th>
						<th>Student Age</th>
						<th>Student Gender</th>
						<th>Student Email</th>
					</tr>
				</thead>
				<tbody>
					<!-- Example Data Rows -->
					<tr>
						<td>1</td>
						<td>John Doe</td>
						<td>21</td>
						<td>Male</td>
						<td>johndoe@example.com</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Jane Smith</td>
						<td>22</td>
						<td>Female</td>
						<td>janesmith@example.com</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Michael Brown</td>
						<td>20</td>
						<td>Male</td>
						<td>michaelbrown@example.com</td>
					</tr>
					<tr>
						<td>4</td>
						<td>Emily Johnson</td>
						<td>23</td>
						<td>Female</td>
						<td>emilyjohnson@example.com</td>
					</tr>
					<tr>
						<td>5</td>
						<td>Chris Evans</td>
						<td>24</td>
						<td>Male</td>
						<td>chrisevans@example.com</td>
					</tr>
					<!-- Additional rows can be added dynamically -->
				</tbody>
			</table>
		</div>
	</main>



</body>

</html>
