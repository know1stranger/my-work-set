package org.ck.edu.code_design_patterns.behavioral.strategy;

import org.ck.edu.code_design_patterns.behavioral.strategy.context.Context;
import org.ck.edu.code_design_patterns.behavioral.strategy.impl.AddStrategy;
import org.ck.edu.code_design_patterns.behavioral.strategy.impl.MultiplicationStrategy;
import org.ck.edu.code_design_patterns.behavioral.strategy.impl.SubstractStrategy;
import org.ck.edu.code_design_patterns.behavioral.strategy.intf.Strategy;

/**
 * Class creates the context and applies different Strategies to provide the
 * result. Context can take new concrete strategy and apply. Composition is used
 * instead of inheritance to support the different strategy.
 * 
 * @author uskarc01
 *
 */
public class StrategyDemo {

	static private String fromClass = "from " + StrategyDemo.class.getSimpleName();

	public static void main(String[] args) {

		System.out.println(fromClass + ": start");

		int x = 10;
		int y = 5;

		Strategy stratergy = new AddStrategy();

		System.out.println("Trail# 1");
		// prep the context
		Context context = new Context(x, y, stratergy);
		// check the result
		context.doMath();

		System.out.println();
		System.out.println("Trail# 2");
		
		// change the strategy
		stratergy = new SubstractStrategy();
		context.setStratergy(stratergy);
		// check the result
		context.doMath();

		System.out.println();
		System.out.println("Trail# 3");
		// change the strategy
		context.setStratergy(new MultiplicationStrategy());
		// check the result
		context.doMath();

		System.out.println(fromClass + ": end");
	}

}
