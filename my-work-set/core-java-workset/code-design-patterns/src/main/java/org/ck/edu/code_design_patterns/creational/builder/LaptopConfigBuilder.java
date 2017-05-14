package org.ck.edu.code_design_patterns.creational.builder;

public abstract class LaptopConfigBuilder {

	// properties similar to laptop
	private String processor;
	private String memoryOne;
	private String memoryTwo;
	private String operatingSys;

	/**
	 * With final method this pattern has become template method-pattern, where
	 * the subclasses cannot override it and can only add distributed impl fo
	 * the abstract methods.
	 * 
	 * @return
	 */
	final public Laptop build() {
		Laptop laptop = configure();
		return laptop;
	}

	/**
	 * This will be well defined in concrete impl
	 * 
	 * @return
	 */
	abstract Laptop configure();

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

}
