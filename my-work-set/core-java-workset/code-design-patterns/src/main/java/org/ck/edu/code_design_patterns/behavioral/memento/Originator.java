package org.ck.edu.code_design_patterns.behavioral.memento;

public class Originator {

	static private String fromClass = "from " + Originator.class.getCanonicalName();

	private int age;
	private String name;
	private int weight;

	public Originator(int age, String name, int weight) {
		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Memento saveMe() {
		System.out.println();
		System.out.println(fromClass + " save me." + " start");
		Memento memento = new Memento(age, name, weight);
		System.out.println(fromClass + " save me." + "end");
		return memento;
	}

	/**
	 * Param is of type @see Object, if we allow @see Memento, then we are
	 * giving visibility to the customers and will force us reveal the private inner
	 * class.
	 * 
	 * @param memento
	 */
	public void restoreMe(Object memento) {
		System.out.println();
		Memento mementoObj = (Memento) memento;
		System.out.println(fromClass + " restore me." + " start");
		
		this.age = mementoObj._age;
		this.name = mementoObj._name;
		this.weight = mementoObj._weight;
		
		System.out.println(fromClass + " restore me." + " end");
	}

	@Override
	public String toString() {
		return this.name + "-" + this.age + "years-" + this.weight + "lbs.";
	}

	/**
	 * Making this private will not allow it; thus, supporting the
	 * memento design pattern.
	 * 
	 * @author uskarc01
	 *
	 */
	private class Memento {

		private int _age;
		private String _name;
		private int _weight;

		public Memento(int _age, String _name, int _weight) {
			this._age = _age;
			this._name = _name;
			this._weight = _weight;
		}

	}
}
