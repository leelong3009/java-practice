package com.sample.crackingthecoding.linkedlist;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class Exc25 {

	public static void main(String[] args) {
		LinkedListNode head1 = initData();
		LinkedListNode head2 = initData2();
		LinkedListNode temp1 = head1;
		LinkedListNode temp2 = head2;
		LinkedListNode sumHead = null;
		LinkedListNode sumTail = null;
		LinkedListNode sumTemp = null;
		
//		while (temp1 != null || temp2 != null) {
//			int addition = 0;
//			if (temp1 != null && temp1.prev != null && temp2 != null && temp2.prev != null) {
//				addition = (temp1.prev.data + temp2.prev.data) / 10;
//			}
//			int value = 0;
//			if (temp1 != null ) {
//				value += temp1.data;
//			}
//			if (temp2 != null ) {
//				value += temp2.data;
//			}
//			
//			value = value %10 + addition;
//			if (sumHead == null) {
//				sumHead = new LinkedListNode(value);
//				sumTail = sumHead;
//			} else {
//				sumTemp = new LinkedListNode(value);
//				sumTail.setNext(sumTemp);
//				sumTail = sumTemp;
//			}
//			temp1 = temp1 == null ? null : temp1.next;
//			temp2 = temp2 == null ? null : temp2.next;
//		}
		
		System.out.println(sumRecursion(head1, head2, 0).printForward());
	}

	private static LinkedListNode sumRecursion(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		
		LinkedListNode sumHead = new LinkedListNode(value % 10);
		if (l1 != null || l2 != null) {
			LinkedListNode next = sumRecursion(l1 != null ? l1.next : null, l2 != null ? l2.next : null, value > 10 ? 1 : 0);
			sumHead.setNext(next);
		}
		
		return sumHead;
	}
	
	private static LinkedListNode initData() {
		LinkedListNode head = new LinkedListNode(7, null, null);
		LinkedListNode temp = head, tail = head;
		
		temp = new LinkedListNode(1);
		tail.setNext(temp);
		tail = temp;
		temp =  new LinkedListNode(6);
		tail.setNext(temp);
		tail = temp;
		System.out.println(head.printForward());
		return head;
	}
	
	private static LinkedListNode initData2() {
		LinkedListNode head = new LinkedListNode(5, null, null);
		LinkedListNode temp = head, tail = head;
		
		temp = new LinkedListNode(9);
		tail.setNext(temp);
		tail = temp;
		temp =  new LinkedListNode(2);
		tail.setNext(temp);
		tail = temp;
		temp =  new LinkedListNode(2);
		tail.setNext(temp);
		tail = temp;
		System.out.println(head.printForward());
		return head;
	}
}
