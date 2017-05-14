package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName = "GreetingsService")
public class GreetingsServiceEndpoint {

	@Autowired
	private GreetingService greetingsServiceIntf;

	@WebMethod(operationName = "getGreetings")
	public String getGreeting(@WebParam(name = "name", targetNamespace = "com.service") String name) {
		System.out.println("name:" + name);
		return greetingsServiceIntf.getGreetings(name);
	}

	@WebMethod(exclude = true)
	public void setGreetingServiceIntf(GreetingService greetingsServiceIntf) {
		this.greetingsServiceIntf = greetingsServiceIntf;
	}

}
