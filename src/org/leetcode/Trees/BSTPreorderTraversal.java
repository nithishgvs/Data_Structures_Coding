package org.leetcode.Trees;

import org.junit.Test;

import java.util.Stack;

public class BSTPreorderTraversal {
	/**
	 * Visit->Left->Right
	 * 
	 * @param root
	 */
	public static void PreorderTraversalRecursive(TreeNodeCustom root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		PreorderTraversalRecursive(root.getLeftChild());
		PreorderTraversalRecursive(root.getRightChild());
	}

	/**
	 * Visit->Left->Right
	 * 
	 * @param root
	 */
	public static void PreorderTraversalIterative(TreeNodeCustom root) {
		Stack<TreeNodeCustom> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNodeCustom current = stack.pop();
			System.out.print(current.getData() + " ");
			if (current.getRightChild() != null) {
				stack.push(current.getRightChild());
			}
			if (current.getLeftChild() != null) {
				stack.push(current.getLeftChild());
			}

		}
	}

	private TreeNodeCustom populateBinarySearchTree() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNodeCustom rootNode = null;
		rootNode = binarySearchTree.insertionIterative(rootNode, 52);
		binarySearchTree.insertionIterative(rootNode, 33);
		binarySearchTree.insertionIterative(rootNode, 65);
		binarySearchTree.insertionIterative(rootNode, 25);
		binarySearchTree.insertionIterative(rootNode, 39);
		binarySearchTree.insertionIterative(rootNode, 60);
		binarySearchTree.insertionIterative(rootNode, 78);
		binarySearchTree.insertionIterative(rootNode, 72);
		binarySearchTree.insertionIterative(rootNode, 90);
		binarySearchTree.insertionIterative(rootNode, 12);
		binarySearchTree.insertionIterative(rootNode, 27);
		binarySearchTree.insertionIterative(rootNode, 34);
		binarySearchTree.insertionIterative(rootNode, 48);
		return rootNode;
	}

	@Test
	public void PreorderRecursiveTest() {
		TreeNodeCustom root = populateBinarySearchTree();
		System.out.println("PreOrder Recursive");
		PreorderTraversalRecursive(root);
		System.out.println();
	}

	@Test
	public void PreorderIterativeTest() {
		TreeNodeCustom root = populateBinarySearchTree();
		System.out.println("PreOrder Iterative");
		PreorderTraversalIterative(root);
		System.out.println();
	}
}
