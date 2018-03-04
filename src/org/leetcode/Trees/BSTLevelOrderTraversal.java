package org.leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BSTLevelOrderTraversal {

	/**
	 * Print Each Level
	 * 
	 * @param root
	 */
	public void LevelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode item = queue.poll();
			if (item.getLeftChild() != null) {
				queue.add(item.getLeftChild());
			}
			if (item.getRightChild() != null) {
				queue.add(item.getRightChild());
			}
			System.out.print(item.getData() + " ");
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
	public void LevelOrderTraversalTest() {
		TreeNode root = populateBinarySearchTree();
		System.out.println("LevelOrder Traversal");
		LevelOrderTraversal(root);
		System.out.println();
	}

}
