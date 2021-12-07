package com.sample.crackingthecoding.linkedlist;

import com.sample.crackingthecoding.lib.LinkedListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedListNode head = initData();
		System.out.println(reverseList(head).printForward());
	}
	
	private static LinkedListNode reverseList(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
	
	private static LinkedListNode trivialSolution(LinkedListNode head) {
		LinkedListNode rhead = null;
		LinkedListNode temp = head;
        while (temp != null) {
        	LinkedListNode next = temp.next;
            temp.next = null;
            if (rhead == null) {
                rhead = temp;
            } else {
                temp.next = rhead;
                rhead = temp;
            }
            temp = next;
        }
        return rhead;
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
}
