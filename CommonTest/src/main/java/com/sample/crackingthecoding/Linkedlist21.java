package com.sample.crackingthecoding;

import java.util.HashSet;
import java.util.Set;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class Linkedlist21 {

	private static void removeDuplications(LinkedListNode n) {
		Set<Integer> set = new HashSet<Integer>();
		LinkedListNode tempNode = null;
		while (n != null) {
			if (set.contains(n.data)) {
				tempNode.next = n.next;
			} else {
				set.add(n.data);
				tempNode = n;
			}
			n = n.next;
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
		removeDuplications(head);
		System.out.println(head.printForward());
	}

}
