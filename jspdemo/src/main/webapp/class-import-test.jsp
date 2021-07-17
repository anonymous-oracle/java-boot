<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.demo.jsp.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lower case "HELLO WORLD": 
	<%= Utils.makeItLowerCase("HELLO WORLD") %> <!-- WITH IMPORTING CLASS --> 
 	<%-- Lower case "HELLO WORLD": 
	<%=com.demo.jsp.Utils.makeItLowerCase("HELLO WORLD")%> <!-- WITHOUT IMPORTING CLASS -->  --%> 
</body>
</html>