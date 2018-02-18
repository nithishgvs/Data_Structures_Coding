package org.nithishgvs.binarytree;

import org.junit.Test;

public class Validate_BST_98 {
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static boolean validateBST(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			return true;
		}
		if (root.getLeftChild() != null && root.getLeftChild().getData() < root.getData()
				&& root.getRightChild() != null && root.getRightChild().getData() > root.getData()) {
			return validateBST(root.getLeftChild()) && validateBST(root.getRightChild());
		}
		return false;
	}

	@Test
	public void testValidateBstPositiveCase() {
		Node<Integer> root = populateBinaryTree();
		System.out.println(validateBST(root));
	}

	@Test
	public void testValidateBstNegativeCase() {
		Node<Integer> root = populateBinaryTreeManual();
		System.out.println(validateBST(root));
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

	/**
	 * Api method to populate Binary Tree
	 * 
	 * @return
	 */
	private static Node<Integer> populateBinaryTreeManual() {
		Node<Integer> root = new Node<Integer>(52);
		root.setLeftChild(new Node<Integer>(33));
		root.setRightChild(new Node<Integer>(65));
		root.getLeftChild().setLeftChild(new Node<Integer>(55));
		root.getLeftChild().setRightChild(new Node<Integer>(100));
		root.getRightChild().setLeftChild(new Node<Integer>(6));
		root.getRightChild().setRightChild(new Node<Integer>(7));
		return root;
	}
}
