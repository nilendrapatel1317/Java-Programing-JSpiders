<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Fetch All Employees</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<style type="text/css">
		/* custom scroll bar */
		::-webkit-scrollbar {
			width: 5px;
		}
		
		::-webkit-scrollbar-track {
			background: #f1f1f1;
		}
		
		::-webkit-scrollbar-thumb {
			background: #CFE2FF;
			border-radius: 50px;
		}
		
		::-webkit-scrollbar-thumb:hover {
			background: #2E81E7;
		}
	</style>
</head>

<body class="bg-light d-flex flex-column min-vh-100">
	<%@ include file="header.jsp" %>
	<main class="container my-4 flex-grow-1">
		<a href="/EmployeeManagementSystem/index.jsp">Return to Homepage</a>
		<div class="my-3 d-flex justify-content-between align-items-center">
			<h2 class="text-center text-primary">Employees List</h2>
			<form action="/EmployeeManagementSystem/fetchAllEmployees"
				method="get" class="d-flex justify-content-center">
				<select name="searchType" class="form-select w-75 me-2">
					<option value="id">Search by ID</option>
					<option value="name">Search by Name</option>
					<option value="email">Search by Email</option>
				</select> <input type="text" name="searchQuery"
					class="form-control w-100 me-2" placeholder="Enter search term">
				<button type="submit" class="btn btn-primary">Search</button>
			</form>

		</div>
		<div class="table-responsive"
			style="max-height: 66vh; overflow-y: auto;">
			<table
				class="table table-bordered table-striped text-center align-middle">
				<thead class="table-primary">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Email</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.age}</td>
							<td>${employee.gender}</td>
							<td>${employee.email}</td>
							<td>
								<form action="/EmployeeManagementSystem/editEmployee.jsp"
									method="post">
									<input type="hidden" name="id" value="${employee.id}">
									<input type="hidden" name="name" value="${employee.name}">
									<input type="hidden" name="age" value="${employee.age}">
									<input type="hidden" name="gender" value="${employee.gender}">
									<input type="hidden" name="email" value="${employee.email}">
									<button type="submit" class="btn btn-warning">Edit</button>
								</form>
							</td>
							<td>
								<form action="/EmployeeManagementSystem/deleteEmployee"
									method="post">
									<input type="hidden" name="id" value="${employee.id}">
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>

</body>

</html>
