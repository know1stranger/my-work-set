package com.inc;

import javax.jws.WebService;

@WebService(endpointInterface = "com.inc.HelloWorldIntf", serviceName = "HelloWorldImpl")
public class HelloWorld implements HelloWorldIntf {

	public String sayHi(String name) {
		return "Hi" + name;
	}

}
