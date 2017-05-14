package org.ck.edu.code_design_patterns.structural.adapter;

public class Volt {

	static private String fromClass = "from " + Volt.class.getCanonicalName();

	private int voltage = 0;

	/**
	 * voltage is set a the creation
	 * @param voltage
	 */
	public Volt( int voltage) {
		this.voltage = voltage;
	}

	public int getVoltage() {
		return voltage;
	}

	
	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return Integer.toString(getVoltage()) + " volts";
	}
}
