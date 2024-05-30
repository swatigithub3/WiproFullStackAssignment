package com.stack;

public class StackDemo {

	public static void main(String[] args) {
		StackUsingArrays s = new StackUsingArrays();
		System.out.println("Is stack empty? " + s.isEmpty());
		s.push('a');
		s.push('b');
		s.push('c');
		s.push('d');
		s.push('e');
		s.push('f');
		System.out.println("Top element is: " +s.peek());
		System.out.println("Popped element is: " +s.pop());
		System.out.println("Popped element is: " +s.pop());
		System.out.println("Top element is: " +s.peek());
		System.out.println("Is stack empty? " + s.isEmpty());
		

	}

}
