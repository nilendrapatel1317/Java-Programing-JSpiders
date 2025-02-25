<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Form</h1>
	<form action="register" method="post">
	Name : <input type="text" name="name"><br><br>
	Username : <input type="text" name="username"><br><br>
	Age : <input type="number" name="age"><br><br>
	Gender : <input type="text" name="gender"><br><br>
	Email : <input type="email" name="email"><br><br>
	Password : <input type="password" name="password"><br><br>
	Confirm Password : <input type="password" name="confirmPassword"><br><br>
	<input type="submit" value="Register Now">
	
	</form>
</body>
</html>