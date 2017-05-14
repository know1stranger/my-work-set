package com.ck.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private String userID ="eck";
	private String password = "eck";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		System.out.println("encode prj:login-user:" + user);

		if (userID.equals(user) && password.equals(pwd)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			
			
			Cookie loginCookie = new Cookie("user", user);
			// setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			response.sendRedirect(response.encodeURL("loginSuccess.jsp"));
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
