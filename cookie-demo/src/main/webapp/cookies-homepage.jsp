<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Training Home Page</title>
</head>
<body>
	<h3>Training Portal</h3>

	// read the programming language cookie
	<%
	// the default...if there are no cookies
	String favLang = "Java";

	// get the cookies form the browser request
	Cookie[] cookies = request.getCookies();

	// find our favorite programming language cookie
	if (cookies != null) {
		for (Cookie tempCookie : cookies) {

			if ("myApp.favoriteLanguage".equals(tempCookie.getName())) {
		favLang = tempCookie.getValue();
		break;
			}

		}
	}
	%>
	<!-- PERSONALIZATION BEGINS -->
	<h4>
		New Books for
		<%=favLang%></h4>
	<ul>
		<li>....</li>
		<li>....</li>
		<li>....</li>
	</ul>

	<h4>
		Latest News for
		<%=favLang%></h4>
	<ul>
		<li>....</li>
		<li>....</li>
		<li>....</li>
	</ul>

	<h4>
		Jobs for
		<%=favLang%></h4>
	<ul>
		<li>....</li>
		<li>....</li>
		<li>....</li>
	</ul>
	<hr>
	<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>