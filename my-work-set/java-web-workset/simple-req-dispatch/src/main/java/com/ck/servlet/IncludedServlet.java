package com.ck.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludedServlet extends HttpServlet {

	private String fromClass = "\t from " + getClass().getSimpleName() + ":";

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {

		System.out.println("\n-->" + fromClass);
		getSpecialAttributes(httpServletRequest);

		System.out.println(fromClass + " getServletPath: " + httpServletRequest.getServletPath());

		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.print(fromClass);

		System.out.println(fromClass + "I can still write here...!, but text to writer will not be displayed.");

	}

	/**
	 * @param httpServletRequest
	 */
	private void getSpecialAttributes(HttpServletRequest httpServletRequest) {
		
		
		System.out.println(httpServletRequest.getAttribute("javax.servlet.include.servlet_path"));
		

		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration = httpServletRequest.getAttributeNames();
		//enumeration = getServletContext().getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String strAtrName = enumeration.nextElement();

			System.out.println(fromClass + strAtrName + "--" + httpServletRequest.getAttribute(strAtrName));
		}
	}

}
