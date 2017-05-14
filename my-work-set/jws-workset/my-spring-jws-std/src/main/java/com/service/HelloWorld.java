package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

/**
 * 
 * @author uskarc01
 *
 */

// @Service is for component-scan and its used by Spring to detect beans (like
// this) and publish the
// @WebService with bean configuration(SimpleJaxWsServiceExporter) provided for
// export.

@Service
@WebService(serviceName = "HelloWorld")
public class HelloWorld {

	@WebMethod
	public String sayHi(@WebParam(name = "text") String text) {
		System.out.println("log:sayHi called");
		return "Hello " + text;
	}

}
