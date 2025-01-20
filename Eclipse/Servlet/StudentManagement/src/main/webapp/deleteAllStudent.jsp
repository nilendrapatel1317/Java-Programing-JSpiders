<!DOCTYPE html>
<html>
<head>
    <title>Delete Student Confirmation</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
</head>

<body class="bg-light d-flex justify-content-center align-items-center flex-column-reverse gap-4 min-vh-100">
    <div class="bg-white p-4 rounded shadow text-center" style="width: 100%; max-width: 600px;">
        <h2 class="">Are You Sure You Want to</h2>
        <h2 class=" mb-4">Delete All Student Records ?</h2>
        <form action="deleteAllStudents" method="post">
            <!-- Yes Button -->
            <button type="submit" class="btn btn-danger w-25 me-3">Yes</button>
            
            <!-- No Button -->
            <a href="/StudentManagement/index.jsp" class="btn btn-secondary w-25">No</a>
        </form>
    </div>
</body>

</html>
