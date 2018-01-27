package org.nithishgvs.binarytree;

import org.junit.Test;

public class InorderBinarySearchTree {

	public void inOrderRecursive(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		inOrderRecursive(rootNode.getLeftChild());
		System.out.print(rootNode.getData()+", ");
		inOrderRecursive(rootNode.getRightChild());
	}

	@Test
	public void inorderRecursiveTest() {

		TreeNode rootNode = populateBinarySearchTree();
		inOrderRecursive(rootNode);
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

}
