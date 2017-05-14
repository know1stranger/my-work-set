package com.ck.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckedServlet extends HttpServlet {

	private String fromClass = "\t from " + getClass().getSimpleName() + ":";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doProcess(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doProcess(req, resp);

	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String userName = null;
		Principal principal = req.getUserPrincipal();
		if (principal != null) {
			userName = principal.getName();
			System.out.println(fromClass);
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("Hello " + userName);
	}
}
