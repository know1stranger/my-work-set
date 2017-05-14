package com.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Commented the @webservice to make it simple intf. This is class is invoked by
 * the endpoint layer which will have the required annotations.
 * 
 * @author uskarc01
 *
 */
@WebService(serviceName="AccountService")
public interface AccountService {

	@WebMethod
	public String getTesting();

}
