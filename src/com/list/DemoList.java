package com.list;

public class DemoList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtBeginning(8);
		list.insertAtBeginning(7);
		list.insertAtBeginning(6);
		list.display();
		System.out.println("");
		list.insertAtPos(1,5);
		list.display();
		

	}

}
