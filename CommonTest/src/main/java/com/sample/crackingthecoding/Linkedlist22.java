package com.sample.crackingthecoding;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class Linkedlist22 {

	private static void findKthElement(LinkedListNode n, int k) {
		LinkedListNode temp = n;
		while (temp.next != null) {
			temp = temp.next;
		}
		for (int i=1; i<k; i++) {
			temp = temp.prev;
		}
		System.out.println(temp.data);
	}
	
	private static int findKthElementRecursion(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = findKthElementRecursion(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th last node is " + head.data);
		}
		return index;
	}
	
	public static void main(String[] args) {
		LinkedListNode tail = new LinkedListNode(0, null, null);
		LinkedListNode head = tail;
		LinkedListNode temp = tail;
		
		for (int i = 0; i < 8; i++) {
			temp = new LinkedListNode(i%3, null, null);
			tail.setNext(temp);
			temp.setPrevious(tail);
			tail = temp;
		}
		
		System.out.println(head.printForward());
		
		findKthElementRecursion(head,3);
	}

}
