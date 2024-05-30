package com.day12;


public class RemoveDuplicatesFromSortedList {
	static class ListNode{
		int val;
		ListNode next;
		ListNode (int x){
			val = x;
		}
	}
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		while(temp != null && temp.next != null) {
			if(temp.val ==temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}
	public static void printList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);
		System.out.println("Original list: ");
		printList(head);
		head = deleteDuplicates(head);
		System.out.println("List after removing duplicates: ");
		printList(head);		

	}

}


