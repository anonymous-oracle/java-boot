<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation Title</title>
</head>
<body>
	The student is confirmed:
	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>
</body>
</html>