package com.exp1.client;

import java.util.ArrayList;
import java.util.List;

import com.exp1.Animal;
import com.exp1.Bird;
import com.exp1.Cat;
import com.exp1.Dog;

public class AnimalDoctor {

	public static void main(String[] args) {

		AnimalDoctor animalDoctor = new AnimalDoctor();

		Bird bird = new Bird();
		Cat cat = new Cat();
		Dog dog = new Dog();

		Animal[] arrayRef = new Animal[3];

		// Dog[] arrayRef = new Dog[3];
		arrayRef[0] = bird;
		arrayRef[1] = cat;
		arrayRef[2] = dog;

		System.out.println("array for supertype");
		animalDoctor.doCheckup(arrayRef);

		List<Dog> dogListRef = new ArrayList<>();
		dogListRef.add(dog);
		System.out.println("genric-type of dog");
		// No Add. What you can send as arg is any parameterized-type that
		// is subtype of the method declaration.
		animalDoctor.doCheckup_doAllowMultiple_PType_List(dogListRef);

		List<Cat> catListRef = new ArrayList<>();
		catListRef.add(cat);
		System.out.println("genric-type of cat");
		// No Add. What you can send as arg is any parameterized-type that
		// is subtype of the method declaration.
		animalDoctor.doCheckup_doAllowMultiple_PType_List(catListRef);

		List<Animal> mixedListRef = new ArrayList<>();
		mixedListRef.add(dog);
		mixedListRef.add(cat);

		System.out.println("genric-type of Animal");
		// this is easy - just to hold&add elements of subtypes of
		// parameterized-type
		animalDoctor.doInsert_doAllowMixedWithOutSuper(mixedListRef);

		// it is accepting mixed list, but element restriction is applied. To
		// restrict more see doInsert_doAllowWithSuperToAddSpecific
		animalDoctor.doInsert_doAllowWithSuper(mixedListRef);

		// this is easy - just add type element mentioned in definition
		animalDoctor.doInsert_doAllowWithSuperToAddSpecific(dogListRef);
		// it is accepting mixed list but restrict to add to dog element
		animalDoctor.doInsert_doAllowWithSuperToAddSpecific(mixedListRef);

	}

	/**
	 * To keep the polymorphic nature - but only call the methods exposed by
	 * Animal interface
	 * 
	 * @param array
	 */
	void doCheckup(Animal[] array) {

		// array[0] = new Cat();

		for (Animal animal : array) {
			if (animal != null)
				animal.check();
		}
	}

	/**
	 * To keep the polymorphic nature - but only call the methods exposed by
	 * Animal interface
	 * 
	 * Strictly no add method to be called.
	 * 
	 * @param arrayList
	 */
	void doCheckup_doAllowMultiple_PType_List(List<? extends Animal> arrayList) {
		for (Animal animal : arrayList) {
			animal.check();
		}
	}

	/**
	 * Generic method to hold/add the elements that are subtype of Animal.
	 * Upperbound (Any type whos super type Animal)
	 * 
	 * Note: This declaration is restricting the user to assign collection that
	 * can be assigned, though you can add element to the collection. Here
	 * choice is made with supertype (Animal) see doInsertDog
	 * 
	 * @param superList
	 */
	void doInsert_doAllowWithSuper(List<? super Animal> superList) {
		superList.add(new Dog());
		superList.add(new Cat());
	}

	/**
	 * This can only take dog list or any super type of it. But you can add only
	 * Lowerbound (Only Dog Type)
	 * 
	 * 
	 * This method accepting list but will only restrict itself to add type
	 * elements.
	 * 
	 * @param superList
	 */
	void doInsert_doAllowWithSuperToAddSpecific(List<? super Dog> superList) {
		superList.add(new Dog());
		// you cannot add for this list
		// superList.add(new Cat());
	}

	/**
	 * Generic method to hold/add the elements that are subtype of Animal.
	 * 
	 * 
	 * Note: This declaration is restricting the user to assign collection that
	 * can be assigned, though you can add element to the collection.
	 * 
	 * @param superList
	 */
	void doInsert_doAllowMixedWithOutSuper(List<Animal> superList) {
		superList.add(new Dog());
		superList.add(new Cat());
	}
}
