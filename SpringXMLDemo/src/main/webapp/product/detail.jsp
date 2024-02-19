<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		${productDB.name}
		${productDB.id}
		${prouctDB.price}
		${prouctDB.getQuantity()}
		${prouctDB.getQuantity() > 0 ? 'Con hang'
</body>
</html>