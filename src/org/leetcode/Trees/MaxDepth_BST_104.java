package org.leetcode.Trees;

import org.junit.Test;

public class MaxDepth_BST_104 {

	private int MaxDepthBst(Node<Integer> root) {
		if (root == null)
			return 0;
		else if (root.getLeftChild() == null && root.getRightChild() == null) {
			return 1;
		} else {
			return 1 + Math.max(MaxDepthBst(root.getLeftChild()), MaxDepthBst(root.getRightChild()));
		}

	}

	@Test
	public void testMaxDepthBst() {
		Node<Integer> root = populateBinaryTree();
		System.out.println("Max depth of BST: " + MaxDepthBst(root));
	}

	/**
	 * Api method to populate Binary Tree
	 * 
	 * @return
	 */
	private static Node<Integer> populateBinaryTree() {
		Node<Integer> root = new Node<Integer>(52);
		root.setLeftChild(new Node<Integer>(33));
		root.setRightChild(new Node<Integer>(65));
		root.getLeftChild().setLeftChild(new Node<Integer>(25));
		root.getLeftChild().setRightChild(new Node<Integer>(39));
		root.getLeftChild().getLeftChild().setLeftChild(new Node<Integer>(12));
		root.getLeftChild().getLeftChild().setRightChild(new Node<Integer>(27));
		root.getLeftChild().getRightChild().setLeftChild(new Node<Integer>(34));
		root.getLeftChild().getRightChild().setRightChild(new Node<Integer>(48));
		root.getRightChild().setLeftChild(new Node<Integer>(60));
		root.getRightChild().setRightChild(new Node<Integer>(78));
		root.getRightChild().getRightChild().setLeftChild(new Node<Integer>(72));
		root.getRightChild().getRightChild().setRightChild(new Node<Integer>(90));
		root.getRightChild().getRightChild().getRightChild().setRightChild(new Node<Integer>(100));
		return root;
	}

}
