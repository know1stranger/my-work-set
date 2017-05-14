package com.ck.impl;

import com.ck.intf.MyContext;

public class MyBasicContext implements MyContext {

	String name = null;

	public MyBasicContext() {
		this.name = "SimpleContext";
	}

	@Override
	public String getName() {
		return name;
	}

}
