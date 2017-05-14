package org.ck.edu;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.AccountService;

/**
 * Hello world!
 *
 */
public class StandaloneClientApp {
	private static final String fromClassName = "StandaloneClientApp";

	public static void main(String[] args) {
		System.out.println(fromClassName);

		ApplicationContext applicationContext = null;
		AccountService accountService = null;
		
		try {
			
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			accountService = (AccountService) applicationContext.getBean("localAccountWebService");
			
		} catch (BeansException e) {
			System.out.println("It is all the message we got here. " + e.getMessage());
			System.out.println("It is all the cause we got here. "+e.getCause());
			e.printStackTrace();
		}

		if (accountService != null) {
			System.out.println(accountService);

			System.out.println("response from the service: " + accountService.getTesting());

			// closing the context container
			((ClassPathXmlApplicationContext) applicationContext).close();
		}

	}
}
 