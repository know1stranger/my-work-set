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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private String userID ="ck";
	private String password = "pwd";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		System.out.println("cookie prj:login-user:" + user);

		if (userID.equals(user) && password.equals(pwd)) {
			Cookie loginCookie = new Cookie("user", user);
			// setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(10);
			response.addCookie(loginCookie);
			response.sendRedirect("loginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
