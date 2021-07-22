
<%@ page import="java.util.*"%>
<html>
<body>
	<!-- THIS FORM SUBMITS DATA BACK TO THIS PAGE ITSELF -->
	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="theItem" /> <input
			type="submit" value="Submit" /> <br>
		<!-- IF THE PARAMETER DOES NOT HAVE A VALUE THEN NO OUTPUT WILL BE DISPLAYED -->
	</form>


	<%
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	// IF THE ITEM LIST DOES NOT EXIST CREATE A NEW ONE
	if (items == null) {
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}

	// SEE IF THERE IS FORM DATA TO ADD
	String theItem = request.getParameter("theItem");
	if (theItem != null) {
		items.add(theItem);
	}
	%>
	<hr>
	<b>To-Do List Items: </b>
	<br>

	<ol>
		<%
		for (String temp : items) {
			out.println("<li>" + temp + "</li>");
		}
		%>

	</ol>


</body>
</html>