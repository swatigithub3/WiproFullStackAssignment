package com.day12;

public class LinkedList {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int val){
			data = val;
			next = null;
		}
	}
	void printMiddle() {
		Node slowPointer = head;
		Node fastPointer = head;
		if(head != null) {
			while(fastPointer != null && fastPointer.next != null) {
				fastPointer = fastPointer.next.next;
				slowPointer = slowPointer.next;
			}
			System.out.println("The Middle Element is [ " + slowPointer.data + " ]");
		}
	}
	public void addToTheLast(Node node) {
		if(head == null) {
			head = node;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));
		list.addToTheLast(new Node(5));
		list.printMiddle();
		

	
	}
}



