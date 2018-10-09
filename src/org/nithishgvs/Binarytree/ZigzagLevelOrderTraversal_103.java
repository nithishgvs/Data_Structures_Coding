package org.nithishgvs.Binarytree;

import java.util.Stack;

import org.junit.Test;

public class ZigzagLevelOrderTraversal_103 {
    /**
     * 
     * @param root
     */
	public static void ZigZagTraversal(Node<Integer> root) {

		if (root == null) {
			return;
		}

		Stack<Node<Integer>> stack1 = new Stack<>();
		stack1.add(root);

		Stack<Node<Integer>> stack2 = new Stack<>();

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				Node<Integer> elem = stack1.pop();
				System.out.print(elem.getData() + " ");
				if (elem.getLeftChild() != null) {
					stack2.add(elem.getLeftChild());
				}
				if (elem.getRightChild() != null) {
					stack2.add(elem.getRightChild());
				}
			}
			while (!stack2.isEmpty()) {
				Node<Integer> elem = stack2.pop();
				System.out.print(elem.getData() + " ");
				if (elem.getRightChild() != null) {
					stack1.add(elem.getRightChild());
				}
				if (elem.getLeftChild() != null) {
					stack1.add(elem.getLeftChild());
				}
			}
		}

	}

	@Test
	public void testZigZagTraversal() {
		Node<Integer> root = populateBinaryTree();
		ZigZagTraversal(root);
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
