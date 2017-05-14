<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookie-loginSuccess</title>
</head>
<body>
	<%
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("cookie prj:" + cookie.getName() + " -->" + cookie.getValue());
				if (cookie.getName().equals("user")) {
					userName = cookie.getValue();
					//System.out.println("cookie prj:Did we come for userName:" + userName);
				}
				else if (cookie.getName().equals("JSESSIONID")) {
					sessionID = cookie.getValue();
					//System.out.println("cookie prj: Did we come for JSESSIONID:" + sessionID);
				}
			}
		}
		if (userName == null){
			response.sendRedirect("login.html");
		}
	%>
	<h3>
		Hi
		<%=userName%>, Login successful. Your (Cookie)Session ID=<%=sessionID%>
	</h3>
	<br>
	<form action="logoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>