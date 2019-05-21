package com.sample.crackingthecoding;

import java.util.HashSet;
import java.util.Set;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class Linkedlist22 {

	private static int findKthElement(LinkedListNode n, int k) {
		if (n.next == null) {
			return 0;
		} else {
			return findKthElement(n.next, k) + 1;
		}
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
		
		for (int i = 0; i < 8; i++) {
			System.out.println(i + " " + findKthElement(head, i));
		}
	}

}
