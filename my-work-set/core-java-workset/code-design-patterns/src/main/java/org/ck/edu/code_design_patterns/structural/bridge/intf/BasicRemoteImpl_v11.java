package org.ck.edu.code_design_patterns.structural.bridge.intf;

public class BasicRemoteImpl_v11 implements BasicRemote {

	static private String fromClass = "from "+BasicRemoteImpl_v11.class.getSimpleName();
	
	/**
	 * Latest and greatest impl for the basic operation
	 */
	public void basicChannelOperation() {
		System.out.println(fromClass + ": " + "Here you can navigate through the channels...remotely with swipe.");
	}

}
