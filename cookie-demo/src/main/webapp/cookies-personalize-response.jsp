<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<%
// read form data
String favLang = request.getParameter("favoriteLanguage");

// create a cookie
Cookie cookie = new Cookie("myApp.favoriteLanguage", favLang);

// set cookie life span in seconds
cookie.setMaxAge(60 * 60 * 24 * 365); // for one year
%>
<body>
	Thanks! We set your favorite language to:
	<%=favLang%>

	<br>
	<a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>