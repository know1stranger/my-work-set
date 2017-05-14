package org.ck.edu.code_design_patterns.behavioral.strategy.impl;

import org.ck.edu.code_design_patterns.behavioral.strategy.intf.Strategy;

public class SubstractStrategy implements Strategy {

	public int calculate(int x, int y) {
		return (x-y);
	}

}
