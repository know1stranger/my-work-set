package org.ck.edu.code_design_patterns.structural.adapter;

public class Adapter {

	static private String fromClass = "from " + Adapter.class.getCanonicalName();

	private ElectricSocket electricSocket;

	private static final int HIGH_SAFE_RANGE = 220;

	public void setSocket(ElectricSocket electricSocket) {
		this.electricSocket = electricSocket;
	}

	/**
	 * This is adapter calling the actual socket object, through composition.
	 * (Could be invoked through inheritance by extending ElectricSocket).
	 * 
	 * @return
	 */
	public Volt startToAdapt() {
		System.out.println(fromClass + " in startToAdapt");

		Volt volts = electricSocket.drawVoltage();

		if (volts != null) {
			int voltage = volts.getVoltage();
			// Adapter technology is to set to safe operating volts.
			if (voltage > HIGH_SAFE_RANGE) {
				volts.setVoltage(HIGH_SAFE_RANGE);
			}
		}

		System.out.println(fromClass + ": " + volts.getVoltage() + " volts.");
		return volts;
	}

}
