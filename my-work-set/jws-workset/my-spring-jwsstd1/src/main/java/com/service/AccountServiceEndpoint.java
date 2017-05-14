package com.service;

import javax.jws.WebMethod;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author uskarc01
 * @Service annotation is used by the spring to load the services.
 * @Webserice annotation is used to configure this as Webservice. In this case
 *            as we are exposing the service endpoints with the spring inbuilt
 *            SimpleJaxWsServiceExporter it will register with the internal
 *            JAX-WS runtime server.
 */
@Service
@WebService(serviceName = "AccountService")
public class AccountServiceEndpoint {

	@Autowired
	private AccountService biz;

	@WebMethod
	public String getTesting() {
		System.out.println("From the endpoint. Call will be delegated to the biz service.");
		return biz.getTesting();
	}

}
