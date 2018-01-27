package org.nithishgvs.binarytree;

import org.junit.Test;

public class BinarySearchTreeHeight {

	public static int heightOfBSTRecursive(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}

		return Math.max(heightOfBSTRecursive(rootNode.getLeftChild()), heightOfBSTRecursive(rootNode.getRightChild()))
				+ 1;
	}

	@Test
	public void heightOfBSTTest() {
		TreeNode rootNode = populateBinarySearchTree();
		System.out.println(heightOfBSTRecursive(rootNode));
		rootNode = populateBinarySearchTree1();
		System.out.println(heightOfBSTRecursive(rootNode));
	}

	private TreeNode populateBinarySearchTree() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNode rootNode = null;
		rootNode = binarySearchTree.insertionIterative(rootNode, 10);
		binarySearchTree.insertionIterative(rootNode, 5);
		binarySearchTree.insertionIterative(rootNode, 30);
		binarySearchTree.insertionIterative(rootNode, 2);
		binarySearchTree.insertionIterative(rootNode, 41);
		binarySearchTree.insertionIterative(rootNode, 42);
		binarySearchTree.insertionIterative(rootNode, 8);
		binarySearchTree.insertionIterative(rootNode, 52);
		binarySearchTree.insertionIterative(rootNode, 31);
		BinarySearchTreeInsertion inst = new BinarySearchTreeInsertion();
		inst.inOrderRecursive(rootNode);
		System.out.println();
		return rootNode;
	}

	private TreeNode populateBinarySearchTree1() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNode rootNode = null;
		rootNode = binarySearchTree.insertionIterative(rootNode, 10);
		binarySearchTree.insertionIterative(rootNode, 5);
		binarySearchTree.insertionIterative(rootNode, 30);
		binarySearchTree.insertionIterative(rootNode, 2);
		binarySearchTree.insertionIterative(rootNode, 41);
		binarySearchTree.insertionIterative(rootNode, 42);
		binarySearchTree.insertionIterative(rootNode, 8);
		BinarySearchTreeInsertion inst = new BinarySearchTreeInsertion();
		inst.inOrderRecursive(rootNode);
		System.out.println();
		return rootNode;
	}

}
