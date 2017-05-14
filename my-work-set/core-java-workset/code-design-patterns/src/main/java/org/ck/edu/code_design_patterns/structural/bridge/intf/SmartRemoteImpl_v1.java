package org.ck.edu.code_design_patterns.structural.bridge.intf;

public class SmartRemoteImpl_v1 extends BasicRemoteImpl_v11 implements SmartRemote {

	static private String fromClass = "from " + SmartRemoteImpl_v1.class.getSimpleName();

	/**
	 * new feature on the smart remote.
	 */
	public void viewPip() {
		System.out.println(fromClass + ": " + "Now view the next channel PIP.");
	}

	/**
	 * new feature with voice support. 
	 */
	public void voiceChannelChange() {
		System.out.println(fromClass + ": " + "Now change the next channel with VOICE.");
	}

}
