package org.ck.edu.code_design_patterns.structural.adapter;

public class ElectricSocket {

	static private String fromClass = "from " + ElectricSocket.class.getCanonicalName();
	
	private Volt houseVolt = new Volt(220);

	public ElectricSocket() {
	}

	public Volt drawVoltage() {
		return houseVolt;
	}

}
