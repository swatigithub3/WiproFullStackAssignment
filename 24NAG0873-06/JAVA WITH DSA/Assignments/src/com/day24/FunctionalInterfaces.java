package com.day24;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Persons{
	String name;
	int age;
	public Persons(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}

public class FunctionalInterfaces {
	public static void operateOnPerson(Persons person, 
			Predicate<Persons> predicate, 
			Function<Persons, String> function, 
			Consumer<String> consumer, 
			Supplier<Integer> supplier) {
		if(predicate.test(person)) {
			String result = function.apply(person);
			consumer.accept(result);
		} else {
			int age = supplier.get();
			System.out.println("The person's age is: " + age);
		}
	}

	public static void main(String[] args) {
		Persons person = new Persons("John", 40);
		operateOnPerson(
				person,
				p -> p.age >= 18,
				p -> "Name: " + p.name + ", Age: " + p.age,
				System.out::println,
				() -> 0
				);

	}

}
