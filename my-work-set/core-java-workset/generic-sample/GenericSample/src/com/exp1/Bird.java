package com.exp1;

public class Bird implements Animal {

	@Override
	public void check() {
		System.out.println(this.getClass().getSimpleName() +" check.");
	}

}
