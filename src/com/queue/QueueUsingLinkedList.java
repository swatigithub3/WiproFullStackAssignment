package com.queue;

public class QueueUsingLinkedList {
	class Node{
		int data;
		Node next;
		Node(int value){
			data = value;
			next = null;
		}
	}
	Node front,rear;
	QueueUsingLinkedList(){
		front = rear = null;
	}
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(rear == null) {
			front = rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = newNode;
	}
	public int dequeue() {
		if(front == null) {
			throw new IndexOutOfBoundsException("Queue isEmpty");
		}
		Node temp = front;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		return temp.data;
	}

}
