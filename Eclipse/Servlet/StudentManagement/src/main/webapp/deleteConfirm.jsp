<html>
<head>
<title>Delete Student Confirmation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body class="d-flex justify-content-center align-items-center">
	<div class="d-flex justify-content-center align-items-center mt-3">
		<div class="bg-white p-4 rounded shadow"
			style="width: 100%; max-width: 650px;">
			<h5 class="text-center text-primary ">Student ID : <%=request.getAttribute("id")%> </h5>
			<h2 class="text-center text-danger ">Record Deleted Successfully !!</h2>
			<p class="text-center  mt-3">
				<a href="/StudentManagement/index.jsp">Return to Home</a>
			</p>

		</div>
	</div>

</body>

</html>
