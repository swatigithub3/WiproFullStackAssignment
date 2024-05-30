package com.day12;
import java.util.Stack;

public class StackSequenceSearch {
	public static boolean isSequencePresent(Stack<Integer> stack,int[] sequence) {
		if(sequence.length == 0) {
			return true;
		}
		if(stack.isEmpty()) {
			return false;
		}
		Stack<Integer> tempStack = new Stack<>();
		for(Integer elem: stack) {
			tempStack.push(elem);
		}
		int seqIndex = 0;
		while(!tempStack.isEmpty()) {
			int currentElement = tempStack.pop();
			if(currentElement == sequence[seqIndex]) {
				seqIndex++;
				if(seqIndex == sequence.length) {
					return true;
				}
			} else {
				seqIndex = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		int[] sequence1 = {5,4,3};
		int[] sequence2 = {5,6};
		int[] sequence3 = {4};
		int[] sequence4 = {8};
		int[] sequence5 = {1,2,3};
		System.out.println(isSequencePresent(stack, sequence1));
		System.out.println(isSequencePresent(stack, sequence2));
		System.out.println(isSequencePresent(stack, sequence3));
		System.out.println(isSequencePresent(stack, sequence4));
		System.out.println(isSequencePresent(stack, sequence5));

	}

}


