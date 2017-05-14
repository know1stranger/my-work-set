package com.ck.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutActionServlet extends HttpServlet {

	private static final String CURRENT_USER = "USER";
	private static final String fromClass = LogoutActionServlet.class.getSimpleName();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


		// set the session
		HttpSession httpSession = req.getSession();
		
		String loggedinUser = (String) httpSession.getAttribute(CURRENT_USER);
		System.out.println(fromClass +": logOutUser: " + loggedinUser);
		
		httpSession.setMaxInactiveInterval(0);
		httpSession.setAttribute(CURRENT_USER, null);

		/*
		// set the cookie
		Cookie cookie = new Cookie(CURRENT_USER, formTextBoxName);
		cookie.setMaxAge(60 * 3);
		resp.addCookie(cookie);*/

		// Get the encoded URL string
		resp.sendRedirect(resp.encodeURL("index.jsp"));
	}

}
