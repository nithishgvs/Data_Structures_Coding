package org.leetcode.Trees;

/**
 * Spiral Order Traversal Binary Tree
 * 
 * @author nithishgvs
 *
 */
public class SpiralOrderTraversalBinaryTree<T> {
	
	/**
	 * 
	 * @param root
	 */
	public void spiralOrderTraversal(Node<Integer> root){
		
	}
	
	

	
	// Main Method
	public static void main(String[] args) {
		Node<Integer> root = populateBinaryTree();
		SpiralOrderTraversalBinaryTree<Integer> spiralOrder = new SpiralOrderTraversalBinaryTree<Integer>();

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
