package com.sample.crackingthecoding;

import java.util.LinkedList;
import java.util.Queue;

import com.sample.crackingthecoding.lib.AssortedMethods;
import com.sample.crackingthecoding.lib.BTreePrinter;
import com.sample.crackingthecoding.lib.TreeNode;

public class BFS {

	public static void main(String[] args) {
		TreeNode root = AssortedMethods.randomBST(5, 1, 4);
		  
        BTreePrinter.printNode(root);
        
        search(root, 4);
	}

	public static boolean search(TreeNode root, int value) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (queue.peek() != null) {
			TreeNode node = queue.poll();
			if (node.data == value) {
				System.out.println("Found " + value);
				return true;
			} else {
				System.out.println(node.data);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return false;
	}
}
