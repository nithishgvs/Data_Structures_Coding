package org.leetcode.Trees;

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
	public TreeNodeCustom findElementRecursively(TreeNodeCustom rootNode, int data) {

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
	public void findElementIteratively(TreeNodeCustom rootNode, int data) {

		if (rootNode == null) {
			System.out.println("Tree is Empty..Element not found");
			return;
		}

		Queue<TreeNodeCustom> queue = new LinkedList<TreeNodeCustom>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			TreeNodeCustom tempNode = queue.poll();

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

		TreeNodeCustom rootNode = populateBinarySearchTree();
		BinarySearchTreeFindingElement findElement = new BinarySearchTreeFindingElement();
		TreeNodeCustom output = findElement.findElementRecursively(rootNode, 68);

		if (output == null) {
			System.out.println("Element Not found:OOPS!");
		}

	}

	@Test
	public void findElementIterativelyTest() {
		TreeNodeCustom rootNode = populateBinarySearchTree();
		BinarySearchTreeFindingElement findElement = new BinarySearchTreeFindingElement();
		findElement.findElementIteratively(rootNode, 60);
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

}
