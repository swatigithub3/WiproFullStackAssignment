package com.stack;

public class StackUsingArrays {
	char[] stack = new char[5];
	int top;
	StackUsingArrays() {
		top = -1;
	}
	void push(char value) {
		if(top==4) {
			System.out.println("Stack is Full");
		}
		else {
			stack[++top] = value;
		}
	}
	char pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return '\0';
		}
		else {
			return stack[top--];
		}
	}
	char peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return '\0';
		} else {
			return stack[top];
		}
	}
	boolean isEmpty() {
		return top == -1;
	}

}
