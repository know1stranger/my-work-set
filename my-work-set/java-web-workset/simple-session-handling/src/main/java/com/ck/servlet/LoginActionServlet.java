package com.ck.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginActionServlet extends HttpServlet {

	private static final String CURRENT_USER = "USER";
	private static final String fromClass = LoginActionServlet.class.getSimpleName();
	
	int testSessionCounter = 0;
	
	/*
	 * @Override protected void doPost(HttpServletRequest req,
	 * HttpServletResponse resp) throws ServletException, IOException {
	 * 
	 * doProcess(req, resp);
	 * 
	 * }
	 */

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

		String formTextBoxName = req.getParameter("tbxName");

		if (formTextBoxName != null) {
			formTextBoxName = formTextBoxName.toUpperCase();
		} else {
			throw new ServletException("set the name");
		}

		//System.out.println(fromClass+": New user: " + formTextBoxName);
		// set the session
		HttpSession httpSession = req.getSession();
		
		String loggedinUser = (String) httpSession.getAttribute(CURRENT_USER);
		System.out.println(fromClass+": loggedinUser: " + loggedinUser);
		
		testSessionCounter++;
		System.out.println("testSessionCounter: "+testSessionCounter);
		httpSession.setAttribute("COUNT_SESSION_TEST", testSessionCounter);
		
		httpSession.setMaxInactiveInterval(60*1);
		httpSession.setAttribute(CURRENT_USER, formTextBoxName);

		System.out.println("HSessionID: " + httpSession.getId());

		// set the cookie
		Cookie cookie = new Cookie(CURRENT_USER, formTextBoxName);
		cookie.setMaxAge(60*1);
		resp.addCookie(cookie);

		// Get the encoded URL string
		resp.sendRedirect(resp.encodeURL("loginSuccess.jsp"));
	}

}
