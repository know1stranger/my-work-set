package org.ck.edu.code_design_patterns.creational.builder;

public class Intel5ConfigBuilder extends LaptopConfigBuilder {

	static private String fromClass = "from " + Intel5ConfigBuilder.class.getSimpleName();
	private Laptop laptop = null;

	public Intel5ConfigBuilder() {
		//default values
		this.setProcessor("i5");
		this.setMemoryOne("4GB");
		
		laptop = new Laptop(this);
		
	}

	@Override
	Laptop configure() {
		//default configuration values
		this.setProcessor("i5");
		this.setMemoryOne("4GB");
		
		this.setOperatingSys("WIN10 HOME");
		//this.setMemoryTwo("128GB");
		
		laptop.setOperatingSys(this.getOperatingSys());
		laptop.setMemoryTwo(this.getMemoryTwo());
		
		return laptop;
	}

}
