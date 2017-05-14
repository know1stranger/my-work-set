package com.inc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorldIntf {

	@WebMethod
	String sayHi(@WebParam(name = "text") String text);

}
