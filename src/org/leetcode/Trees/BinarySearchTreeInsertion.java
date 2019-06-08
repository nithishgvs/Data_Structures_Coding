package org.leetcode.Trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeInsertion {

	/**
	 * Inserting Node recursively in a Binary Search Tree
	 * 
	 * @param rootNode
	 * @param data
	 * @return
	 */
	public TreeNodeCustom insertionRecursive(TreeNodeCustom rootNode, int data) {

		if (rootNode == null) {
			rootNode = new TreeNodeCustom(data);
			return rootNode;
		}

		if (rootNode.getData() > data) {
			rootNode.setLeftChild(insertionRecursive(rootNode.getLeftChild(), data));
		} else if (rootNode.getData() < data) {
			rootNode.setRightChild(insertionRecursive(rootNode.getRightChild(), data));
		}

		return rootNode;
	}

	/**
	 * Inserting Node iteratively in a Binary Search Tree
	 * 
	 * @param rootNode
	 * @param data
	 * @return
	 */
	public TreeNodeCustom insertionIterative(TreeNodeCustom rootNode, int data) {

		if (rootNode == null) {
			rootNode = new TreeNodeCustom(data);
			return rootNode;
		}

		Queue<TreeNodeCustom> queue = new LinkedList<TreeNodeCustom>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			TreeNodeCustom tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.getLeftChild() == null && tempNode.getData() > data) {
					tempNode.setLeftChild(new TreeNodeCustom(data));
					return rootNode;
				} else if (tempNode.getRightChild() == null) {
					tempNode.setRightChild(new TreeNodeCustom(data));
					return rootNode;
				}
			}

			if (tempNode.getData() > data) {
				queue.add(tempNode.getLeftChild());
			} else {
				queue.add(tempNode.getRightChild());
			}
		}

		return rootNode;

	}

	/**
	 * left->root->right
	 * 
	 * @param root
	 */
	public void inOrderRecursive(TreeNodeCustom rootNode) {
		if (rootNode == null)
			return;
		inOrderRecursive(rootNode.getLeftChild());
		System.out.print(rootNode.getData() + " ");
		inOrderRecursive(rootNode.getRightChild());
	}

	@Test
	public void insertionRecursiveTest() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNodeCustom rootNode = null;
		System.out.println("Insertion Method calls-Recursive");
		rootNode = binarySearchTree.insertionRecursive(rootNode, 52);
		binarySearchTree.insertionRecursive(rootNode, 33);
		binarySearchTree.insertionRecursive(rootNode, 65);
		binarySearchTree.insertionRecursive(rootNode, 25);
		binarySearchTree.insertionRecursive(rootNode, 39);
		binarySearchTree.insertionRecursive(rootNode, 60);
		binarySearchTree.insertionRecursive(rootNode, 78);
		binarySearchTree.insertionRecursive(rootNode, 72);
		binarySearchTree.insertionRecursive(rootNode, 90);
		binarySearchTree.insertionRecursive(rootNode, 12);
		binarySearchTree.insertionRecursive(rootNode, 27);
		binarySearchTree.insertionRecursive(rootNode, 34);
		binarySearchTree.insertionRecursive(rootNode, 48);
		binarySearchTree.inOrderRecursive(rootNode);
	}

	@Test
	public void insertionIterativeTest() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		System.out.println("Insertion Method calls-Iterative");
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
		System.out.println(rootNode.getData());
		binarySearchTree.inOrderRecursive(rootNode);
	}

}
