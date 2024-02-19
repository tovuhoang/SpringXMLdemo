<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.error{
		color :red;
</style>
<body>
	<p>login</p>
	<form action="${pageContext.request.contextPath}/login" method="post">

		${message}
		<div>
			User : <input name="username" value="${param.uname}"> <span class="error">${messageUserName}</span>
		</div>

		<div>
			Password : <input name="password" value="${param.upass}"> <span>${messagePassWord}</span>
		</div>

		<input type="submit" value="Login">
	</form>
</body>
</html>