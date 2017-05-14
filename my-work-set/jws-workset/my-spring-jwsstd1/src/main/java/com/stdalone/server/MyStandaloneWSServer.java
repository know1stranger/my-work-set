package com.stdalone.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyStandaloneWSServer {

	private static final String APPLICATION_CONTEXT_XML = "applicationContext.xml";

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				APPLICATION_CONTEXT_XML);

		Thread.sleep(Long.MAX_VALUE);
	}
}