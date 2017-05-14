package com.ck.impl;

import com.ck.intf.MyContext;

public class MyPhoneContext implements MyContext {

	String name = null;

	public MyPhoneContext() {
		this.name = "PhoneContext";
	}

	@Override
	public String getName() {
		return name;
	}

}
