package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "firstServlet", urlPatterns = {"/firstServlet"})
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// super.doGet(req, resp); // response will be sent to the client

		System.out.println("Is it not coming here at all..!"); // this writing
		resp.getWriter().write("Hello WebWorld -2"); // this will not print if
														// super.get is invoked.
		// resp.getWriter().println("Hello WebWorld!");
	}

}
