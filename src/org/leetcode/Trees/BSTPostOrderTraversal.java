package org.leetcode.Trees;

import java.util.Stack;

import org.junit.Test;

public class BSTPostOrderTraversal {

	/**
	 * Left->Right->Visit
	 * 
	 * @param root
	 */
	public static void PostorderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		PostorderTraversalRecursive(root.getLeftChild());
		PostorderTraversalRecursive(root.getRightChild());
		System.out.print(root.getData() + " ");
	}

	/**
	 * Left->Right->Visit
	 * 
	 * @param root
	 */
	public static void PostorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNode item = stack1.pop();
			stack2.push(item);
			if (item.getLeftChild() != null) {
				stack1.push(item.getLeftChild());
			}
			if (item.getRightChild() != null) {
				stack1.push(item.getRightChild());
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getData() + " ");
		}
	}

	private TreeNode populateBinarySearchTree() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNode rootNode = null;
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
	public void PostOrderRecursiveTest() {
		TreeNode root = populateBinarySearchTree();
		System.out.println("PostOrder Recursive");
		PostorderTraversalRecursive(root);
		System.out.println();
	}

	@Test
	public void PostOrderIterativeTest() {
		TreeNode root = populateBinarySearchTree();
		System.out.println("PostOrder Iterative");
		PostorderTraversalIterative(root);
		System.out.println();
	}

}
