<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String makeItLowerCase(String data){
	return data.toLowerCase();
}
%>
Lower case "HELLO WORLD": <%= makeItLowerCase("HELLO WORLD") %>
</body>
</html>