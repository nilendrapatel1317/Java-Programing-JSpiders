<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<main class="container my-4 flex-grow-1">
		<div class="my-3 d-flex justify-content-between align-items-center">
			<h2 class="text-center text-primary">Student List</h2>
			<form action="/StudentManagement/fetchAllStudents" method="get"
				class="d-flex justify-content-center mt-3">
				<select name="searchType" class="form-select w-75 me-2">
					<option value="id">Search by ID</option>
					<option value="name">Search by Name</option>
					<option value="email">Search by Email</option>
				</select> <input type="text" name="searchQuery"
					class="form-control w-100 me-2" placeholder="Enter search term">
				<button type="submit" class="btn btn-primary">Search</button>
			</form>

		</div>
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
					<c:forEach var="student" items="${studentList}">
						<tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.age}</td>
							<td>${student.gender}</td>
							<td>${student.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>

</body>

</html>
