<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EncodeURL-loginSuccess</title>
</head>
<body>
	<%
		String sessionID = session.getId();
		String userName = (String) session.getAttribute("user");

		if (userName == null) {
			response.sendRedirect("login.html");
		}

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("encode prj:" + cookie.getName() + " -->" + cookie.getValue());
				if (cookie.getName().equals("user")) {
					userName = cookie.getValue();
					//System.out.println("encode prj:Did we come for userName:" + userName);
				} else if (cookie.getName().equals("JSESSIONID")) {
					sessionID = cookie.getValue();
					//System.out.println("encode prj: Did we come for JSESSIONID:" + sessionID);
				}
			}
		}
	%>
	<h4>
		Hi
		<%=userName%>, Login successful. Your (encoded))Session ID=<%=sessionID%>
	</h4>
	<br>
	<form action="logoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>