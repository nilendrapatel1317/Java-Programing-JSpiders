<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction:column-reverse;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    .form-container {
        background: #fff;
        padding: 20px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    .form-container input[type="text"],
    .form-container input[type="password"],
    .form-container select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }

    .form-container input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    .form-container input[type="submit"]:hover {
        background-color: #45a049;
    }

    .form-container label {
        font-size: 14px;
        color: #555;
    }
     .switch{
    	text-align: center;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h1>Login Form</h1>
        <form action="login" method="post">
            <label for="username">Name:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login Now">
        </form>
    </div>
</body>
</html>
