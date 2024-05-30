package com.day12;

public class MergeSortedLists {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
		public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
			ListNode dummy = new ListNode(-1);
			ListNode current = dummy;
			while(l1 != null && l2 != null) {
				if(l1.val <= l2.val) {
					current.next = l1;
					l1 = l1.next;
				} else {
					current.next = l2;
					l2 = l2.next;
				}
				current = current.next;
			}
			if(l1 != null) {
				current.next = l1;
			} else {
				current.next = l2;
			}
			return dummy.next;
		}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		
		ListNode mergedList = mergeTwoLists(l1,l2);
		printList(mergedList);
		

	}
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}



