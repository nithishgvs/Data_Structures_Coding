package org.nithishgvs.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * PreOrderTraversal of Binary Tree
 * 
 * @author nithishgvs
 *
 * @param <T>
 */

public class PreOrderTraversalBinaryTree<T> {

	private Node<T> root;

	/**
	 * root->left->right
	 * 
	 * @param root
	 */
	public void preOrderRecursive(Node<T> root) {
		if (root == null)
			return;

		System.out.print(root.getData() + " ");
		preOrderRecursive(root.getLeftChild());
		preOrderRecursive(root.getRightChild());
	}

	/**
	 * root->left->right Uses a Stack and Queue
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	public void preOrderIterative(Node<T> root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		Queue<Node> queue = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<T> tmp = stack.pop();
			if (tmp != null) {
				queue.add(tmp);
				stack.push(tmp.getRightChild());
				stack.push(tmp.getLeftChild());
			}
		}
		while (queue.size() != 0) {
			System.out.print(queue.poll().getData() + " ");
		}
	}

	// Main Method
	public static void main(String[] args) {
		PreOrderTraversalBinaryTree<Integer> preorder = new PreOrderTraversalBinaryTree<Integer>();
		Node<Integer> root = populateBinaryTree();
		preorder.preOrderIterative(root);

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
