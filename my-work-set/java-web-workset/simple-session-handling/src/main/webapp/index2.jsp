<html>
<body>
	<%
		String user = (String)session.getAttribute("CURRENT_USER");
		if (user == null) {
			user = "user";
		}
	%>
	<h2>
		Hello
		<%=user%></h2>
</body>
</html>
