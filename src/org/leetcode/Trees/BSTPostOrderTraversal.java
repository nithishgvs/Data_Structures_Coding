package org.leetcode.Trees;

import org.junit.Test;

import java.util.Stack;

public class BSTPostOrderTraversal {

	/**
	 * Left->Right->Visit
	 * 
	 * @param root
	 */
	public static void PostorderTraversalRecursive(TreeNodeCustom root) {
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
	public static void PostorderTraversalIterative(TreeNodeCustom root) {
		Stack<TreeNodeCustom> stack1 = new Stack<>();
		Stack<TreeNodeCustom> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNodeCustom item = stack1.pop();
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
	public void PostOrderRecursiveTest() {
		TreeNodeCustom root = populateBinarySearchTree();
		System.out.println("PostOrder Recursive");
		PostorderTraversalRecursive(root);
		System.out.println();
	}

	@Test
	public void PostOrderIterativeTest() {
		TreeNodeCustom root = populateBinarySearchTree();
		System.out.println("PostOrder Iterative");
		PostorderTraversalIterative(root);
		System.out.println();
	}

}
