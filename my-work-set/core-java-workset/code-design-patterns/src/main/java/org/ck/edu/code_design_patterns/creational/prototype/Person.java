package org.ck.edu.code_design_patterns.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Cloneable,Serializable {

	static private String fromClass = "from " + Person.class.getCanonicalName();

	// primitive
	private int age = 0;
	// string type object
	private String personName;
	// custom type object
	private Thing thing;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Thing getThing() {
		return thing;
	}
	public void setThing(Thing personThing) {
		this.thing = personThing;
	}
	@Override
	public String toString() {
		return age + "-" + personName + "-" + thing;
	}

	protected Person clone() throws CloneNotSupportedException {
		/**
		 * super clone will not deep copy the properties rather use the same
		 * objects with the new cloned obj.
		 */
		System.out.println(fromClass + "..CLONNING..!");
		return (Person) super.clone();
	}

	/**
	 * 
	 * @return
	 */
	protected Person deepCopy() {
		Person personObj = null;
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(this);

			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

			personObj = (Person) objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personObj;

	}

}
