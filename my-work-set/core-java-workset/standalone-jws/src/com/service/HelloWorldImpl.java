package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "HelloWorld")
public class HelloWorldImpl {

	@WebMethod
	public String sayHi(@WebParam(name = "text") String text) {
		System.out.println("log:sayHi called");
		return "Hello " + text;
	}

}
