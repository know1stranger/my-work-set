package org.ck.edu.code_design_patterns.structural.adapter.client;

import org.ck.edu.code_design_patterns.structural.adapter.Adapter;
import org.ck.edu.code_design_patterns.structural.adapter.Device;
import org.ck.edu.code_design_patterns.structural.adapter.ElectricSocket;
import org.ck.edu.code_design_patterns.structural.adapter.LightDevice;
import org.ck.edu.code_design_patterns.structural.adapter.Volt;

public class UserClient {

	static private String fromClass = "from " + UserClient.class.getCanonicalName();

	public static void main(String[] args) {
		System.out.println(fromClass + ": start");

		System.out.println("Trail# 1");

		ElectricSocket electricSocket = new ElectricSocket();
		Volt volt = electricSocket.drawVoltage();
		System.out.println(fromClass + " we have: " + volt);

		// bumping up the voltage. How could you stop this..? removed set
		// volt.setVoltage(221);

		// using the device without adapter
		Device lightDevice = new LightDevice();
		lightDevice.doWork(volt);

		System.out.println();
		System.out.println("Trail# 2");
		// high voltage
		volt.setVoltage(221);
		lightDevice.doWork(volt);

		System.out.println();
		System.out.println("Trail# 3");

		// high voltage
		volt.setVoltage(221);
		System.out.println(fromClass + " :checking voltage before using adapter: " + electricSocket.drawVoltage().getVoltage() + " volts.");

		Adapter adapter = new Adapter();
		adapter.setSocket(electricSocket);

		Volt safeVolts = adapter.startToAdapt();
		lightDevice.doWork(safeVolts);

		System.out.println();
		System.out.println("Trail# 4");

		// low voltage
		safeVolts.setVoltage(119);
		// adapter.setSocket(electricSocket);
		System.out.println(fromClass + " :checking voltage before using adapter: " + electricSocket.drawVoltage().getVoltage() + " volts.");

		safeVolts = adapter.startToAdapt();
		lightDevice.doWork(safeVolts);

		System.out.println();
		System.out.println("Trail# 5");
		// get a new light and test the safeVolts now..!
		lightDevice = new LightDevice();
		lightDevice.doWork(safeVolts);

		System.out.println();
		System.out.println(fromClass + ": end");
	}

}
