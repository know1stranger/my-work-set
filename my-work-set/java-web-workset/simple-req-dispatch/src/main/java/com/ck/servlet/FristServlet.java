package com.ck.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristServlet extends HttpServlet {
	
	private	String fromClass = "\t from " + getClass().getSimpleName() +":";

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {

		System.out.println("\n-->"+fromClass);
		System.out.println(fromClass+" getServletPath: " + httpServletRequest.getServletPath());

		getSpecialAttributes(httpServletRequest);

		ServletContext servletContext = getServletContext();

		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.print(fromClass);

		String fwdServletPath = "/forwardedServlet";
		RequestDispatcher requestDispatcher = null;

		// dispatch created from a context - thru named-dispatcher.
		// requestDispatcher =
		servletContext.getNamedDispatcher(fwdServletPath.replaceFirst("/", ""));

		// dispatch created from a context.
		 requestDispatcher = servletContext.getRequestDispatcher(fwdServletPath);

		// dispatch created from a request
		//requestDispatcher = httpServletRequest.getRequestDispatcher(fwdServletPath);

		 
		// forwarding request
		 requestDispatcher.forward(httpServletRequest, httpServletResponse);
		// including response
//		requestDispatcher.include(httpServletRequest, httpServletResponse);
		printWriter.write(fromClass+"Check requestDispatcher includes here..!");

	}

	/**
	 * 
	 * @param httpServletRequest
	 */
	private void getSpecialAttributes(HttpServletRequest httpServletRequest) {

		Enumeration<String> enumeration = httpServletRequest.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String strAtrName = enumeration.nextElement();
			System.out.println(fromClass +strAtrName + "--" + httpServletRequest.getAttribute(strAtrName));
		}
	}

}
