package com.stdalone.server;

import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.http.HTTPBinding;

import com.service.HelloWorldImpl;

@WebServiceProvider
@ServiceMode(value = Service.Mode.PAYLOAD)
public class MyStandaloneWSServer implements Provider<Source> {

	public Source invoke(Source request) {
		System.out.println("request:"+request);
		return new StreamSource(new StringReader("<p>Hello There!</p>"));
	}

	public static void main(String[] args) throws InterruptedException {

		String address = "http://127.0.0.1:8080/HelloWorldStdWS";
		Endpoint endpoint = Endpoint.create(HTTPBinding.HTTP_BINDING, new MyStandaloneWSServer());
		
		HelloWorldImpl implementor = new HelloWorldImpl();
		
		endpoint.publish(address,implementor);
		
		System.out.println("Service running at " + address);
		System.out.println("Type [CTRL]+[C] to quit!");

		Thread.sleep(Long.MAX_VALUE);
	}
}