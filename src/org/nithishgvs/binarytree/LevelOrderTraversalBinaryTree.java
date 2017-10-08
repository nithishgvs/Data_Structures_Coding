package org.nithishgvs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal BinaryTree
 * 
 * @author nithishgvs
 *
 */
public class LevelOrderTraversalBinaryTree<T> {

	/**
	 * Print nodes at each level before going to another level
	 * 
	 * @param root
	 */
	public void levelOrderTraversal(Node<T> root) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if (temp.getLeftChild() != null) {
				queue.add(temp.getLeftChild());
			}
			if (temp.getRightChild() != null) {
				queue.add(temp.getRightChild());
			}
		}

	}

	// Main Method
	public static void main(String[] args) {
		Node<Integer> root = populateBinaryTree();
		LevelOrderTraversalBinaryTree<Integer> levelorder = new LevelOrderTraversalBinaryTree<Integer>();
		levelorder.levelOrderTraversal(root);
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
