<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
span {
	color: red
}
</style>
</head>
<body>
	<%
	String username = request.getParameter("username");
	%>
	<%
	String password = request.getParameter("password");
	%>

	<%
	session.setAttribute("username", username);
	%>
	<%
	session.setAttribute("password", password);
	%>

	<%
	String user = (String) session.getAttribute("username");
	%>
	<%
	String pswd = (String) session.getAttribute("password");
	%>

	<h1>
		Username is : <span><%=user%></span>
	</h1>
	<h1>
		Password is : <span><%=pswd%></span>
	</h1>

</body>
</html>