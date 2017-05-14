package com.service;

public class GreetingServiceImpl implements GreetingService {

	private String name;

	public String getGreetings(String name) {
		if (name == null) {
			return "hello " + this.name;
		} else {
			return "Have nice day " + name;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

}
