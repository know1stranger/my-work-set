package org.ck.edu.code_design_patterns.creational.prototype;

/**
 * 
 * @author uskarc01
 *
 *         There two ways for creating a prototype Shallow and Deep copying.
 * 
 *         Shallow - This copying will only copy primitives values. And for
 *         objects it references original object values. Hence, any changes made
 *         to those objects will change the values in shallow-clonned object.
 * 
 *         DeepCopy - This copying will copy primitives values and as well
 *         objects with new references. Objects should be implementing
 *         Serializable; otherwise, it will be errored. Hence, any changes made
 *         to those objects will not change the values in deep-clonned object.
 */
public class PrototypeClient {

	static private String fromClass = "from " + PrototypeClient.class.getSimpleName();

	public static void main(String args[]) {

		System.out.println(fromClass + ": start" + "\n");

		Person person = new Person();

		int personAge = 36;
		String personName = "Chet";
		Thing thing = new Thing("CAR");

		person.setAge(personAge);
		person.setPersonName(personName);
		person.setThing(thing);

		System.out.println("--> Orignal Person Obj: " + person);

		try {
			Person clonedPerson = person.clone();

			System.out.println();
			System.out.println("Trail# 1");

			personAge = 37;

			person.setAge(personAge);
			thing.setName("BIKE");

			System.out.println("--> clonedPerson:" + clonedPerson);
			System.out.println("--> person:" + person);

			// checkReferenceEquality(person, clonedPerson);
			// checkReferenceEquality(person.getAge(), clonedPerson.getAge());
			// checkReferenceEquality(person.getPersonName(),
			// clonedPerson.getPersonName());
			// checkReferenceEquality(person.getThing(),
			// clonedPerson.getThing());

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Trail# 2");
		Person deepCopyPerson = person.deepCopy();
		thing.setName("NEW CAR");

		System.out.println("--> deepCopyPerson:" + deepCopyPerson);
		System.out.println("--> person:" + person);

		System.out.println("\n" + fromClass + ": end");
	}

	// static <T extends Object> void checkReferenceEquality(T obj1, T obj2) {
	static <T, U> void checkReferenceEquality(T obj1, U obj2) {
		// System.out.println();
		System.out.println(fromClass + " comparing for: " + obj1.getClass().getCanonicalName());

		if (obj1 == obj2) {
			System.out.println("both refs are referring SAME objects");
		} else {
			System.out.println("both refs are referring DIFF objects");
		}
	}

}
