<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="BankingSystem.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
</head>
<body>
    <%
        // Retrieve user object from session
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            // Redirect to login page if session expired
            response.sendRedirect("/BankingSystem/loginPage.jsp");
        } else {
    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Banking System</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/BankingSystem/logoutPage.jsp">Log Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white text-center">
                        <h3>User Details</h3>
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <tbody>
                                <!-- Row 1 -->
                                <tr>
                                    <th style="width: 50%;">ID</th>
                                    <td style="width: 50%;"><%= user.getId() %></td>
                                </tr>
                                <!-- Row 2 -->
                                <tr>
                                    <th style="width: 50%;">Full Name</th>
                                    <td style="width: 50%;"><%= user.getName() %></td>
                                </tr>
                                <!-- Row 3 -->
                                <tr>
                                    <th style="width: 50%;">Age</th>
                                    <td style="width: 50%;"><%= user.getAge() %></td>
                                </tr>
                                <!-- Row 4 -->
                                <tr>
                                    <th style="width: 50%;">Gender</th>
                                    <td style="width: 50%;"><%= user.getGender() %></td>
                                </tr>
                                <!-- Row 5 -->
                                <tr>
                                    <th style="width: 50%;">City</th>
                                    <td style="width: 50%;"><%= user.getCity() %></td>
                                </tr>
                                <!-- Row 6 -->
                                <tr>
                                    <th style="width: 50%;">Phone</th>
                                    <td style="width: 50%;"><%= user.getPhone() %></td>
                                </tr>
                                <!-- Row 7 -->
                                <tr>
                                    <th style="width: 50%;">Email</th>
                                    <td style="width: 50%;"><%= user.getEmail() %></td>
                                </tr>
                                <!-- Row 8 -->
                                <tr>
                                    <th style="width: 50%;">Account Number</th>
                                    <td style="width: 50%;"><%= user.getAccountNumber() %></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    %>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-IQsoLXlQ2vG8ht9FyQt1wYG2KE3eTMyWxPtIb8UUepoe8XBzJCOUxBalPdHWXl4u"
        crossorigin="anonymous"></script>
</body>
</html>
