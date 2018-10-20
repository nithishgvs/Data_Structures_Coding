package org.leetcode.Trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal_102 {

	private void LeverlOrderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<Integer> temp = queue.poll();
			if (temp.getLeftChild() != null)
				queue.add(temp.getLeftChild());
			if (temp.getRightChild() != null)
				queue.add(temp.getRightChild());
			System.out.print(temp.getData() + " ");
		}

	}

	@Test
	public void testLevelOrderTraversal() {
		Node<Integer> root = populateBinaryTree();
		LeverlOrderTraversal(root);
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
		return root;
	}

}
