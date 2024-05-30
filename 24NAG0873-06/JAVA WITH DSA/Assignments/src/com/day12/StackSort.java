package com.day12;

import java.util.Stack;

public class StackSort {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty()) {
			int current = stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek() > current) {
				stack.push(tempStack.pop());
			}
			tempStack.push(current);
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(98);
		stack.push(43);
		stack.push(89);
		stack.push(33);
		stack.push(12);
		System.out.println("Original stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted stack: " + stack);
		

	}

}
