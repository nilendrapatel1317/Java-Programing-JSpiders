<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h1>Profile Page</h1>
	<div class="card" style="width: 25rem;">
		<div class="card-body">
			<h2 class="card-title">${user.name}</h2>
			<h5 class="card-text">Email : ${user.email}</h5>
			<h5 class="card-text">Password : ${user.password}</h5>
		</div>
	</div>
</body>
</html>
