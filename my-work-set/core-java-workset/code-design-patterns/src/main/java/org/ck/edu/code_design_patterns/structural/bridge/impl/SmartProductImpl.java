package org.ck.edu.code_design_patterns.structural.bridge.impl;

import org.ck.edu.code_design_patterns.structural.bridge.intf.SmartRemote;

public class SmartProductImpl extends BasicProductImpl {

	static private String fromClass = "from " + SmartProductImpl.class.getSimpleName();

	private SmartRemote smartRemote;

	/**
	 * 
	 * @param remote
	 */
	public SmartProductImpl(SmartRemote remote) {
		super(remote);
		smartRemote = remote;
	}

	/**
	 * Overriding the method in new impl, but still doing the old way of work
	 * and new features.
	 */
	public void operateChannel() {
		System.out.println(fromClass);
		
		// do the super way..!
		super.operateChannel();

		/**
		 * explict down casting. We know this class can only be created with
		 * this SmartRemote type. In that case, "this" obj could downcast the
		 * reference here before calling the allowed operations or call this
		 * downcast in the constructor so that it is much clear for future
		 * opertaions what we are working with.
		 */
		// SmartRemote smartRemote = (SmartRemote)this.basicRemote;
		smartRemote.viewPip();
	}

	/**
	 * added voice support in this product implementation.
	 */
	public void voiceSupport() {
		System.out.println(fromClass);
		smartRemote.voiceChannelChange();
	}

}
