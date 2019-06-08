package org.leetcode.Trees;

import org.junit.Test;

public class BinarySearchTreeHeight {

	public static int heightOfBSTRecursive(TreeNodeCustom rootNode) {
		if (rootNode == null) {
			return 0;
		}

		return Math.max(heightOfBSTRecursive(rootNode.getLeftChild()), heightOfBSTRecursive(rootNode.getRightChild()))
				+ 1;
	}

	@Test
	public void heightOfBSTTest() {
		TreeNodeCustom rootNode = populateBinarySearchTree();
		System.out.println(heightOfBSTRecursive(rootNode));
		rootNode = populateBinarySearchTree1();
		System.out.println(heightOfBSTRecursive(rootNode));
	}

	private TreeNodeCustom populateBinarySearchTree() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNodeCustom rootNode = null;
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

	private TreeNodeCustom populateBinarySearchTree1() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNodeCustom rootNode = null;
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
