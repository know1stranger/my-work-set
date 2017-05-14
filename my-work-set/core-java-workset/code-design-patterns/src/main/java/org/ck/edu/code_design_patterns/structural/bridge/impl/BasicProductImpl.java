package org.ck.edu.code_design_patterns.structural.bridge.impl;

import org.ck.edu.code_design_patterns.structural.bridge.intf.BasicRemote;

/**
 * 
 * @author uskarc01
 *
 *         If this class is made abstract what benefits ..? </br>
 *         <ol>
 *         <li>The abstract methods can be always be overridden with new
 *         implementations (i.e. in new concrete classes).</li>
 *         <li>This can evolved to a framework or chain of methods to be
 *         invoked.</li>
 *         <li>Further on framework, we can have diff concrete classes which are
 *         directly extending this class @see BasicProductImpl and also leaving
 *         us to enchance those concreate by having various operations impl and
 *         chains that define their existance (i.e.implementations) that we
 *         don't know now(developing this class).</li>
 *         <li>And importantly keep the bridge to work support (Attained by
 *         composition of Remote interface @see BasicRemote ).</li>
 *         </ol>
 * 
 */
public class BasicProductImpl {

	static private String fromClass = "from " + BasicProductImpl.class.getSimpleName();

	/**
	 * this is protected because we need to keep the access to the extending
	 * classes supporting the bridge evolution.
	 */
	protected BasicRemote basicRemote;

	/**
	 * Every product needs this remote full its operations that are called for.
	 * 
	 * @param remote
	 */
	public BasicProductImpl(BasicRemote remote) {
		this.basicRemote = remote;
	}

	// basic operation on the product
	public void operateChannel() {
		System.out.println(fromClass);
		basicRemote.basicChannelOperation();
	}

}
