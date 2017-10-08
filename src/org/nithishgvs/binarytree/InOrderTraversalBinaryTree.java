package org.nithishgvs.binarytree;

import java.util.Stack;

public class InOrderTraversalBinaryTree<T> {


	/**
	 * left->root->right
	 * 
	 * @param root
	 */
	public void inOrderRecursive(Node<T> root) {
		if (root == null)
			return;
		inOrderRecursive(root.getLeftChild());
		System.out.print(root.getData() + " ");
		inOrderRecursive(root.getRightChild());
	}

	/**
	 * left->root->right
	 * 
	 * Uses a Stack ,Add root to stack and assign it as root(first step).Make
	 * root's left as root and push it to stack if its not null ,if root's left
	 * is null pop from stack and make root's right as root and push it to stack
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	public void inOrderIterative(Node<T> root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeftChild();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				Node<T> temp = stack.pop();
				System.out.print(temp.getData() + " ");
				root = temp.getRightChild();
			}
		}

	}

	// Main method
	public static void main(String[] args) {
		Node<Integer> root = populateBinaryTree();
		InOrderTraversalBinaryTree<Integer> inorder = new InOrderTraversalBinaryTree<Integer>();
		inorder.inOrderIterative(root);

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
