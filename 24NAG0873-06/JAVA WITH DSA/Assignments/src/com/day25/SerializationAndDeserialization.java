package com.day25;

import java.io.*;

class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "}";
	}
}
public class SerializationAndDeserialization {

	public static void main(String[] args) {
		Person person = new Person("Alice", 30);
		System.out.println("Original object: " + person);
		//Serialize the object
		try(FileOutputStream fileOut = new FileOutputStream("person.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut)){
			out.writeObject(person);
			System.out.println("Object serialized to person.ser");
		} catch(IOException i) {
			i.printStackTrace();
		}
		//Deserialize the object
		Person deserializedPerson = null;
		try(FileInputStream fileIn = new FileInputStream("person.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn)){
			deserializedPerson = (Person) in.readObject();
		}catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
		}
		System.out.println("Deserialized object: " + deserializedPerson);

	}

}
