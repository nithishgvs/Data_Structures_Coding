package org.nithishgvs.Binarytree;

import java.util.Stack;

import org.junit.Test;

public class BSTInorderTraversal {

	/**
	 * Left->Visit->Right
	 * 
	 * @param root
	 */
	public static void InorderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		InorderTraversalRecursive(root.getLeftChild());
		System.out.print(root.getData() + " ");
		InorderTraversalRecursive(root.getRightChild());
	}

	/**
	 * Left->Visit->Right(Tushar Roy video)
	 * 
	 * @param root
	 */
	public static void InorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentRoot = root;
		while (true) {
			if (currentRoot != null) {
				stack.add(currentRoot);
				currentRoot = currentRoot.getLeftChild();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				TreeNode poppedElem = stack.pop();
				System.out.print(poppedElem.getData() + " ");
				currentRoot = poppedElem.getRightChild();
			}
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
	public void InorderRecursiveTest() {
		TreeNode root = populateBinarySearchTree();
		System.out.println("Inorder Recursive");
		InorderTraversalRecursive(root);
		System.out.println("");

	}

	@Test
	public void InorderIterativeTest() {
		TreeNode root = populateBinarySearchTree();
		System.out.println("Inorder Iterative");
		InorderTraversalIterative(root);
		System.out.println("");
	}

}
