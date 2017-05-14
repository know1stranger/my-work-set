package org.ck.edu.code_design_patterns.creational.prototype;

import java.io.Serializable;

public class Thing  implements Serializable{

	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Thing(String thingNamed) {
		this.name = thingNamed;
	}

	@Override
	public String toString() {
		return name;
	}
}
