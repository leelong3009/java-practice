package com.sample.crackingthecoding;

import java.util.Stack;

import com.sample.crackingthecoding.lib.AssortedMethods;
import com.sample.crackingthecoding.lib.LinkedListNode;

public class Linkedlist26 {
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(new int[] { 1, 2, 2, 1 });
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(LinkedListNode head) {
        Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
        LinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop().data != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
