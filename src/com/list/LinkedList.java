package com.list;

public class LinkedList<T> {
	Node head;
	class Node{
		T data;
		Node next;
		Node(T val){
			data = val;
			next = null;
		}
	}
	LinkedList(){
		head = null;
	}
	public void insertAtBeginning(T val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
	}
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public void insertAtPos(int pos, T val) {
		if(pos == 0) {
			insertAtBeginning(val);
			return;
		}
		Node newNode = new Node(val);
		Node temp = head;
		for(int i =1; i<=pos-1;i++) {
			temp = temp.next;
		}
		if(temp == null) {
			throw new IndexOutOfBoundsException("Invalid pos " + pos);
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	public void deleteAtPos(int pos) {
		if(head == null) {
			throw new IndexOutOfBoundsException("Deletion attempted on empty list");
		}
		if(pos == 0) {
			head = head.next;
			return;
		}
		Node temp = head;
		Node prev = null;
		for(int i =1; i<=pos;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	public void deleteAtBeginning() {
		if(head == null) {
			throw new IndexOutOfBoundsException("Deletion attempted on empty list");
		}
		head = head.next;
	}

}
