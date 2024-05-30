package com.day12;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;

	public class QueueSorting {
		public static void sortQueue(Queue<Integer> queue) {
			Stack<Integer> stack = new Stack<>();
			
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				while(!stack.isEmpty() && stack.peek() < temp) {
					queue.offer(stack.pop());
				}
				stack.push(temp);
			}
			while(!stack.isEmpty()) {
				queue.offer(stack.pop());
			}
			
		}

		public static void main(String[] args) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(8);
			queue.offer(3);
			queue.offer(5);
			queue.offer(7);
			queue.offer(2);
			queue.offer(4);
			System.out.println("Original queue: " + queue);
			System.out.println(queue.peek());
			sortQueue(queue);
			System.out.println("Sorted queue: " + queue);
			

		}


}
