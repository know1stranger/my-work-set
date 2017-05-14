package org.ck.edu.code_design_patterns.creational.builder.client;

import org.ck.edu.code_design_patterns.creational.builder.Intel5ConfigBuilder;
import org.ck.edu.code_design_patterns.creational.builder.Intel7ConfigBuilder;
import org.ck.edu.code_design_patterns.creational.builder.Laptop;
import org.ck.edu.code_design_patterns.creational.builder.LaptopConfigBuilder;

public class LaptopCustomerClient {

	static private String fromClass = "from " + LaptopCustomerClient.class.getSimpleName();
	public static void main(String[] args) {

		System.out.println(fromClass + ": start");

		// System.out.println("Trail# 1");
		Laptop laptop = null;

		/**
		 * customer could set "any values" to create a laptop config which will
		 * lack being consistent with other. If you need to control builder
		 * pattern will take this creation and help user configure.
		 * 
		 */
		// laptop = new Laptop("i5", "4gb");
		// System.out.println(laptop);

		System.out.println("Trail# 2");
		LaptopConfigBuilder laptopConfigBuilder = new Intel5ConfigBuilder();
		/**
		 * build with the default values in the class @see Intel5ConfigBuilder
		 * overridden method(configure).
		 */
		laptop = laptopConfigBuilder.build();
		System.out.println(laptop);

		System.out.println("Trail# 3");
		laptopConfigBuilder = new Intel7ConfigBuilder();
		// setting value before building
		laptopConfigBuilder.setOperatingSys("LINUX");
		laptopConfigBuilder.setMemoryTwo("256GB");

		laptop = laptopConfigBuilder.build();
		System.out.println(laptop);

		System.out.println(fromClass + ": end");
	}

}
