<html>
<body>

	<%
		//set the user from the session
		String current_user = (String) session.getAttribute("USER");
		String sessionID = session.getId();

		Cookie[] req_cookies = request.getCookies();
		//to suppot the url-rewriting and cookies disablement
		if (req_cookies != null) {
			System.out.println("jsp log: reading cookies");
			int i = 0;
			for (Cookie cookie : req_cookies) {
				i++;
				System.out.println(i + ") " + cookie.getName() + " -->" + cookie.getValue());

				if (cookie.getName().equals("USER")) {
					String cookie_user = cookie.getValue();
					System.out.println("jsp log: set CURRENT_USER:" + current_user);
					System.out.println("jsp log: set cookie_user:" + cookie_user);

					if (current_user != null && current_user.equals(cookie_user)) {
						continue;
					} else {
						//set from cookie
						System.out.println("user differs");
						current_user = cookie_user;
					}
				}
				if (cookie.getName().equals("JSESSIONID")) {
					String cookie_sessionId = cookie.getValue();
					System.out.println("jsp log: set sessionID:" + sessionID);
					System.out.println("jsp log: set cookie_sessionId:" + cookie_sessionId);
					if (sessionID != null && sessionID.equals(cookie_sessionId)) {
						continue;
					} else {
						System.out.println("session differs or session is null");
						//set from cookie
						sessionID = cookie_sessionId;
					}
				}
			}
		}
	%>

	<h3>
		Hi
		<%=current_user%>, Login successful. Your Session ID=<%=sessionID%></h3>
		
		
		
	<br>
	<br>
	<br>
	<a href="<%=response.encodeUrl("nextActionServlet")%>">NextActionLink</a>
	<a href="<%=response.encodeUrl("logoutActionServlet")%>">Logout</a>
	<br>
	<hr color="red">
	<p>
		Here is the count
		<%=(Integer) session.getAttribute("COUNT_SESSION_TEST")%></p>
</body>
</html>
