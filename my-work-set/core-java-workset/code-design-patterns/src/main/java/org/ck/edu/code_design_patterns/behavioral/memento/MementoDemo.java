package org.ck.edu.code_design_patterns.behavioral.memento;

/**
 * This class with demo the Memento design pattern.
 * 
 * @author uskarc01
 *
 */
public class MementoDemo {

	static private String fromClass = "from " + MementoDemo.class.getCanonicalName();
	public static void main(String[] args) {
		System.out.println(fromClass + ": start");
		
		// creating the obj with init values
		Originator originator = new Originator(37, "chet", 170);
		System.out.println("attempt-1 " + originator);

		// changing the obj state with diff value from the previous state
		originator.setWeight(160);
		System.out.println("attempt-2 (saving)" + originator);

		// saving the desired state; in expectation of restore later
		Object orgState = originator.saveMe();

		// obj state happening
		originator.setWeight(165);
		System.out.println();
		System.out.println("attempt-3 (changing after save)" + originator);

		// to restore the old state to the same obj.
		originator.restoreMe(orgState);
		System.out.println("attempt-4 (restored) " + originator);
		
		//second try of validation of save and restoring.
		originator.setName("Chaitanya");
		orgState = originator.saveMe();
		originator.restoreMe(orgState);
		System.out.println("attempt-5 (change, save & restored) " + originator);
		

		System.out.println();
		System.out.println(fromClass + ": end");
	}

}
