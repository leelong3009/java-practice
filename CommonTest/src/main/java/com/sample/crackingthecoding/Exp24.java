package com.sample.crackingthecoding;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class Exp24 {

	public static void main(String[] args) {
		LinkedListNode tail = new LinkedListNode(0, null, null);
		LinkedListNode head = tail;
		LinkedListNode temp = tail;

		for (int i = 0; i < 10; i++) {
			temp = new LinkedListNode(i % 8, null, null);
			tail.setNext(temp);
			temp.setPrevious(tail);
			tail = temp;
		}

		System.out.println(head.printForward());
//
//		LinkedListNode beforeTail = null;
//		LinkedListNode beforeHead = null;
//		LinkedListNode afterTail = null;
//		LinkedListNode afterhead = null;
//
//		temp = head;
//		int pivot = 5;
//		while (temp != null) {
//			LinkedListNode next = temp.next;
//			temp.next = null;
//			if (temp.data < pivot) {
//				if (beforeHead == null) {
//					beforeHead = temp;
//					beforeTail = temp;
//				} else {
//					beforeTail.next = temp;
//					beforeTail = temp;
//				}
//			} else {
//				if (afterhead == null) {
//					afterhead = temp;
//					afterTail = temp;
//				} else {
//					afterTail.next = temp;
//					afterTail = temp;
//				}
//			}
//
//			temp = next;
//		}
//
//		if (beforeTail != null && afterhead != null) {
//			beforeTail.next = afterhead;
//		}

		System.out.println(partition(head, 5).printForward());
	}

	private static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode tail = node;
		LinkedListNode head = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. -> append node to the left of head, then update head to node*/
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. -> append node to the right of tail, then update tail to node*/
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		// The head has changed, so we need to return it to the user.
		return head;
	}
}
