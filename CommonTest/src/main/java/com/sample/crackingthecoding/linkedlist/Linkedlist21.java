package com.sample.crackingthecoding.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.sample.crackingthecoding.lib.AssortedMethods;
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
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 1, 4);
		
		System.out.println(head.printForward());
		removeDuplications(head);
		System.out.println(head.printForward());
	}

}
