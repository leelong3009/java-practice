package com.sample.crackingthecoding;

import java.util.Arrays;
import java.util.Stack;

import com.sample.crackingthecoding.lib.AssortedMethods;
import com.sample.crackingthecoding.lib.BTreePrinter;
import com.sample.crackingthecoding.lib.TreeNode;

public class DFS {

	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		TreeNode root = AssortedMethods.randomBST(10, 1, 5);
  
        BTreePrinter.printNode(root);
        System.out.println("\nInorder traversal of binary tree is "); 
        search(root, 3);
        System.out.println(Arrays.toString(stack.toArray()));
	}

	private static boolean search(TreeNode root, int value) {
		if (root == null) {
			return false;
		}
		stack.push(root.data);
		if (root.data == value) {
			return true;
		} else {
			boolean leftR=false, rightR=false;
			
			leftR = search(root.left, value);
			
			if (!leftR)
			rightR = search(root.right, value);
						
			if (!leftR && !rightR) {
				stack.pop();
				return false;
			} else {
				return true;
			}
		}
	}
}
