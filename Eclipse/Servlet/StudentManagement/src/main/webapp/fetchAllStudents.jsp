<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Fetch All Students</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="bg-light d-flex flex-column min-vh-100">

    <p class="text-center mt-3">
        <a href="/StudentManagement/index.jsp">Return to Home</a>
    </p>
    <!-- Main Content -->
    <main class="container my-4 flex-grow-1">
        <h2 class="text-center text-primary mb-4">Student List</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-striped text-center align-middle">
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
                    <!-- Use JSTL to iterate through studentList -->
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
