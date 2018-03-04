package org.leetcode.Trees;

import java.util.Stack;

/**
 * Post Order Traversal of Binary Tree
 * 
 * @author nithishgvs
 *
 */
public class PostOrderTraversalBinaryTree<T> {

	/**
	 * left->right->root
	 * 
	 * @param root
	 */
	public void postOrderRecursive(Node<T> root) {
		if (root == null)
			return;
		postOrderRecursive(root.getLeftChild());
		postOrderRecursive(root.getRightChild());
		System.out.print(root.getData() + " ");

	}

	/**
	 * left->right->root Uses 2 stacks (S1,S2) pushes root(first step) on S1 and
	 * copies root from S1 to S2 and if S1 has left and right copies to S1 and
	 * so on
	 * 
	 * @param root
	 */
	public void postOrderIterative(Node<T> root) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.add(root);
		while (!stack1.isEmpty()) {
			Node<T> temp = stack1.pop();
			stack2.push(temp);
			if (temp.getLeftChild() != null) {
				stack1.push(temp.getLeftChild());
			}
			if (temp.getRightChild() != null) {
				stack1.push(temp.getRightChild());
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getData() + " ");
		}

	}

	// Main Method
	public static void main(String[] args) {
		Node<Integer> root = populateBinaryTree();
		PostOrderTraversalBinaryTree<Integer> postorder = new PostOrderTraversalBinaryTree<Integer>();
		postorder.postOrderIterative(root);
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
