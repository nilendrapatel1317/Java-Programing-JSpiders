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

<body class="bg-light d-flex justify-content-center align-items-center min-vh-100">
    <div class="bg-white p-4 rounded shadow" style="width: 100%; max-width: 400px;">
        <h2 class="text-center text-primary mb-4">Edit Student</h2>
        <form action="updateStudent" method="post">
            <!-- Student ID (Read-only) -->
            <div class="mb-3">
                <label for="id" class="form-label">ID <span class="text-danger">[read-only]</span></label>
                <input type="text" class="form-control" id="id" name="id"
                    value="<%= request.getAttribute("id") %>" readonly>
            </div>

            <!-- Name -->
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name"
                    placeholder="Enter your name" value="<%= request.getAttribute("name") %>">
            </div>

            <!-- Age -->
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age"
                    placeholder="Enter your age" value="<%= request.getAttribute("age") %>">
            </div>

            <!-- Gender -->
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <select class="form-select" id="gender" name="gender">
                    <option value="male" <%= "male".equals(request.getAttribute("gender")) ? "selected" : "" %>>Male</option>
                    <option value="female" <%= "female".equals(request.getAttribute("gender")) ? "selected" : "" %>>Female</option>
                    <option value="other" <%= "other".equals(request.getAttribute("gender")) ? "selected" : "" %>>Other</option>
                </select>
            </div>

            <!-- Email (Read-only) -->
            <div class="mb-3">
                <label for="email" class="form-label">Email <span class="text-danger">[read-only]</span></label>
                <input type="email" class="form-control" id="email" name="email"
                    value="<%= request.getAttribute("email") %>" readonly>
            </div>

            <!-- Submit Button -->
            <div class="d-grid">
                <button type="submit" class="btn btn-primary text-white">Save Changes</button>
            </div>
        </form>

        <!-- Return to Home -->
        <p class="text-center mt-3">
            <a href="/StudentManagement/index.jsp">Return to Home</a>
        </p>
    </div>
</body>
</html>
