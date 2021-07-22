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

	The student's country:
	<%=request.getParameter("country")%>
	<br> The student's favorite programming language:
	<%=request.getParameter("favoriteLanguage")%>
	<br> Languages known by the student:
	<ul>
		<%
		String[] langs = request.getParameterValues("knownLanguage");
		for (int i = 0; i < langs.length; i++) {
			out.println("<li>" + langs[i] + "</li>");
		}
		%>
	</ul>
	<br>
</body>
</html>