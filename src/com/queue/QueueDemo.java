package com.queue;

public class QueueDemo {

	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList() ;
		q.enqueue(5);	
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		System.out.println("Dequeued " +q.dequeue());
		System.out.println("Dequeued " +q.dequeue());
		System.out.println("Dequeued " +q.dequeue());
		System.out.println("Dequeued " +q.dequeue());

	}

}
