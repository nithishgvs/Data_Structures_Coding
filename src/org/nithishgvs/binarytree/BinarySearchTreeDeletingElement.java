package org.nithishgvs.binarytree;

import org.junit.Test;

public class BinarySearchTreeDeletingElement {

	/**
	 * Delete an element from Binary Search Tree Recursively
	 * 
	 * @param rootNode
	 * @param data
	 * @return
	 */
	// Here there are 3 Scenarios
	// Scenario 1:-If the element is Leaf Node just delete it
	// Scenario 2:- If not Leaf Node and has one child then Copy the
	// child to the node location and delete the child
	// Scenario 3:-If the node has 2 children then Copy contents of the inorder
	// successor to the node and delete the inorder successor. Note that
	// inorder predecessor can also be used.The important thing to note
	// is, inorder successor is needed only when right child is not
	// empty. In this particular case, inorder successor can be obtained
	// by finding the minimum value in right child of the node
	
	public TreeNode deleteElementRecursive(TreeNode rootNode, int data) {

		if (rootNode == null) {
			System.out.println("Element Not Found! OOPS");
			return null;
		}
		if (rootNode.getData() > data) {
			rootNode.setLeftChild(deleteElementRecursive(rootNode.getLeftChild(), data));
		} else if (rootNode.getData() < data) {
			rootNode.setRightChild(deleteElementRecursive(rootNode.getRightChild(), data));
		} else {

			if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
				System.out.println("Scenario 1 case.. Element Found and Deleting: " + rootNode.getData());
				return (rootNode = null);
			} else if (rootNode.getLeftChild() == null) {
				System.out.println("Scenario 2 case.. Element Found and Deleting: " + rootNode.getData());
				rootNode = rootNode.getRightChild();
				return rootNode;
			} else if (rootNode.getRightChild() == null) {
				System.out.println("Scenario 2 case.. Element Found and Deleting: " + rootNode.getData());
				rootNode = rootNode.getLeftChild();
				return rootNode;
			} else {
				System.out.println("Scenario 3 case.. Element Found and Deleting: " + rootNode.getData());
				int inorderSuccessor = findInorderSuccessor(rootNode.getRightChild());
				deleteElementRecursive(rootNode, inorderSuccessor);
				rootNode.setData(inorderSuccessor);
				return rootNode;
			}

		}
		return rootNode;
	}

	private int findInorderSuccessor(TreeNode rightChild) {
		TreeNode temp = rightChild;

		while (temp.getLeftChild() != null) {
			temp = temp.getLeftChild();
		}
		return temp.getData();
	}

	@Test
	public void deleteElementRecursiveTest() {
		TreeNode rootNode = populateBinarySearchTree();
		BinarySearchTreeDeletingElement deleteElement = new BinarySearchTreeDeletingElement();
		deleteElement.deleteElementRecursive(rootNode, 78);
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		binarySearchTree.inOrderRecursive(rootNode);

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
		// binarySearchTree.insertionIterative(rootNode, 47);
		return rootNode;
	}

}
