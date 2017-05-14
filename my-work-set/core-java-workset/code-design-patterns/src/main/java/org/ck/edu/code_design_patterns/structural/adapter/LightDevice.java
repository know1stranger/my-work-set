package org.ck.edu.code_design_patterns.structural.adapter;

public class LightDevice implements Device {

	static private String fromClass = "from " + LightDevice.class.getCanonicalName();

	private String status = "Need voltage to work..!";
	
	//oops blownout you need to discard and create a new device.
	private boolean blownOut = false;

	public void doWork(Volt volt) {

		if (!blownOut) {
			
			if (volt != null) {
				int voltage = volt.getVoltage();
				if (voltage >= 120 && voltage <= 220) {
					this.status = "Light is ON..!";
				} else if (voltage < 120) {
					this.status = "Not sufficient light ..!";
				} else if (voltage > 220) {
					blownOut = true;
					this.status = "Blown-OUT light ..!";
				}

			}
		}

		getStatus();
	}

	/**
	 * get the status
	 */
	private void getStatus() {
		System.out.println(fromClass + " status:" + status);
	}

}
