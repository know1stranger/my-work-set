package org.ck.edu.code_design_patterns.behavioral.strategy.context;

import org.ck.edu.code_design_patterns.behavioral.strategy.intf.Strategy;

/**
 * 
 * My observation - if this @see Context implements the @see Strategy, we are
 * getting more coupled with the operations to be called and ending up in State
 * Design pattern.
 * 
 * @author uskarc01
 *
 */
public class Context {

	private int x;
	private int y;

	/**
	 * Strategy pattern is one way that composition can be used as an
	 * alternative to sub-classing. Associating the interface here will give
	 * flexibility to use different implementations.
	 **/
	private Strategy strategy;

	static private String fromClass = "from " + Context.class.getSimpleName();

	public Context(int x, int y, Strategy strategy) {
		this.x = x;
		this.y = y;
		this.strategy = strategy;
	}

	/**
	 * This method will do the calculation and actual calculation is abstracted
	 * from the user. Although, the behaviors are different, the different
	 * strategies all operate on data from the Context.
	 */
	public void doMath() {
		System.out.println(fromClass + " in doMath");

		int result = strategy.calculate(x, y);
		System.out.println(String.format("stratergy applied \"%s\" for x=%s, y %s which resulted: %s", strategy.getClass().getSimpleName(),
				x, y, result));

	}

	/**
	 * Method allows us to change strategy. Changing the Context's strategy,
	 * different behaviors can be obtained.
	 * 
	 * @param stratergy
	 */
	public void setStratergy(Strategy stratergy) {
		this.strategy = stratergy;
	}

}
