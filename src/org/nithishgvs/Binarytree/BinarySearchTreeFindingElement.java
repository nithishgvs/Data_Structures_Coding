package org.nithishgvs.Binarytree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeFindingElement {

	/**
	 * Finding Element recursively in a Binary Search Tree
	 * 
	 * @param rootNode
	 * @param data
	 * @return
	 */
	public TreeNode findElementRecursively(TreeNode rootNode, int data) {

		if (rootNode == null) {
			return null;
		}

		if (rootNode.getData() > data) {
			findElementRecursively(rootNode.getLeftChild(), data);
		} else if (rootNode.getData() < data) {
			findElementRecursively(rootNode.getRightChild(), data);
		} else if (rootNode.getData() == data) {
			System.out.println("Element Found: " + rootNode.getData());
		}

		return null;
	}

	/**
	 * Finding Element iteratively in a Binary Search Tree
	 * 
	 * @param rootNode
	 * @param data
	 */
	public void findElementIteratively(TreeNode rootNode, int data) {

		if (rootNode == null) {
			System.out.println("Tree is Empty..Element not found");
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();

			if (tempNode == null) {
				System.out.println("Element Not found:OOPS!");
				return;
			} else if (tempNode.getData() == data) {
				System.out.println("Element Found: " + tempNode.getData());
				return;
			}

			if (tempNode.getData() > data) {
				queue.add(tempNode.getLeftChild());
			} else {
				queue.add(tempNode.getRightChild());
			}
		}

	}

	@Test
	public void findElementRecursivelyTest() {

		TreeNode rootNode = populateBinarySearchTree();
		BinarySearchTreeFindingElement findElement = new BinarySearchTreeFindingElement();
		TreeNode output = findElement.findElementRecursively(rootNode, 68);

		if (output == null) {
			System.out.println("Element Not found:OOPS!");
		}

	}

	@Test
	public void findElementIterativelyTest() {
		TreeNode rootNode = populateBinarySearchTree();
		BinarySearchTreeFindingElement findElement = new BinarySearchTreeFindingElement();
		findElement.findElementIteratively(rootNode, 60);
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
