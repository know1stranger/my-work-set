<html>
<body>
	<%
		String sessionUser = (String) session.getAttribute("USER");
		String user = (sessionUser==null)?"":sessionUser;
	%>
	<p>
	<h2>
		Hello <%=user%></h2>
	<form action="<%=response.encodeUrl("loginActionServlet")%>
		method="
		get" name="indexForm">
		name:<input name="tbxName" type="text" maxlength="15" width="15"
			value="<%=user%>"><br> <br> <br> <input
			type="submit" value="Submit" /> <br>
	</form>
	<br>
	<br>
	<br>
	<a href="<%=response.encodeUrl("nextActionServlet")%>">NextActionLink</a>
	<a href="<%=response.encodeUrl("logoutActionServlet")%>">Logout</a>
	<a href="<%=response.encodeUrl("loginSuccess.jsp")%>">Try-Login-Success</a>

	<hr color="red">
	<p>
		Here is the count
		<%=(Integer) session.getAttribute("COUNT_SESSION_TEST")%></p>

</body>
</html>
