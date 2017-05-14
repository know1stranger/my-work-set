package org.ck.edu.code_design_patterns.structural.bridge.intf;

public class BasicRemoteImpl_v1 implements BasicRemote {

	static private String fromClass = "from " + BasicRemoteImpl_v1.class.getSimpleName();
	
	/**
	 * Very basic way of operation, will be overridden in the next
	 * implementations.
	 */
	public void basicChannelOperation() {
		System.out.println(fromClass + ": " + "Here you can navigate through the channels...remotely.");
	}

}
