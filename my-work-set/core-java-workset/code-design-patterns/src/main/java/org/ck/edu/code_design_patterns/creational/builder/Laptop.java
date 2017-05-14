/**
 * 
 */
package org.ck.edu.code_design_patterns.creational.builder;

/**
 * @author uskarc01
 *
 */
public class Laptop {

	static private String fromClass = "from " + Laptop.class.getSimpleName();

	private String processor;
	private String memoryOne;
	private String memoryTwo;
	private String operatingSys;
	LaptopConfigBuilder configBuilder;

	/**
	 *
	 * Keeping it public will allow the customer to create. Making private will
	 * restrict user creating it. Making protected/default will demand for the
	 * client to be in the same package.
	 * 
	 * 
	 * 
	 * @param processor
	 * @param memoryOne
	 */

	Laptop(LaptopConfigBuilder configBuilder) {

		/**
		 * This object could be made much simple by taking the construction work
		 * to another class and will call and set the values. So this will be
		 * unaware of the builder thing.
		 */

		// reading from builder
		this.processor = configBuilder.getProcessor();
		this.memoryOne = configBuilder.getMemoryOne();
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMemoryOne() {
		return memoryOne;
	}

	public void setMemoryOne(String memoryOne) {
		this.memoryOne = memoryOne;
	}

	public String getMemoryTwo() {
		return memoryTwo;
	}

	public void setMemoryTwo(String memoryTwo) {
		this.memoryTwo = memoryTwo;
	}

	public String getOperatingSys() {
		return operatingSys;
	}

	public void setOperatingSys(String operatingSys) {
		this.operatingSys = operatingSys;
	}

	@Override
	public String toString() {
		return this.processor + "-" + this.memoryOne + "-" + this.memoryTwo + "-" + this.operatingSys;
	}
}
