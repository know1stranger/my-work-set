package org.ck.edu.code_design_patterns.behavioral.strategy.intf;

public interface Strategy {

	/**
	 * Different algorithms are represented as Concrete Strategy classes
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int calculate(int x, int y);
}
