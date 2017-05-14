package org.ck.edu.code_design_patterns.creational.builder;

public class Intel7ConfigBuilder extends LaptopConfigBuilder {

	static private String fromClass = "from " + Intel7ConfigBuilder.class.getSimpleName();

	private Laptop laptop;

	public Intel7ConfigBuilder() {
		
		this.setProcessor("i7");
		this.setMemoryOne("16GB");
		
		laptop = new Laptop(this);
	}

	@Override
	Laptop configure() {
		//set the values the needed 
		laptop.setOperatingSys(this.getOperatingSys());
		laptop.setMemoryTwo(this.getMemoryTwo());
		
		return laptop;
	}

}
