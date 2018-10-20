package org.nithishgvs.Binarytree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalBinaryTrees {
	/**
	 * Finding if two BST's are same
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean identicalBSTRecursive(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else {
			if (root1 != null && root2 != null) {
				if (root1.getData() == root2.getData()) {
					return true && identicalBSTRecursive(root1.getLeftChild(), root2.getLeftChild())
							&& identicalBSTRecursive(root1.getRightChild(), root2.getRightChild());
				}
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Finding if two BST's are same
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean identicalBSTIterative(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.add(root1);
		queue2.add(root2);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode elem1 = queue1.poll();
			TreeNode elem2 = queue2.poll();
			if (elem1 != null && elem2 != null) {
				if (elem1.getData() == elem2.getData()) {
					queue1.add(elem1.getLeftChild());
					queue2.add(elem2.getLeftChild());
					queue1.add(elem1.getRightChild());
					queue2.add(elem2.getRightChild());
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;

	}

	@Test
	public void identicalBSTRecursivePositiveTest() {
		TreeNode testNode = populateBinarySearchTree();
		TreeNode testNode1 = populateBinarySearchTree1();
		System.out.println("Positive Recursive Test Result: " + identicalBSTRecursive(testNode, testNode1));
	}

	@Test
	public void identicalBSTRecursiveNegativeTest() {
		TreeNode testNode = populateBinarySearchTree();
		TreeNode testNode2 = populateBinarySearchTree2();
		System.out.println("Negative Recursive Test Result: " + identicalBSTRecursive(testNode, testNode2));
	}

	@Test
	public void identicalBSTIterativePositiveTest() {
		TreeNode testNode = populateBinarySearchTree();
		TreeNode testNode1 = populateBinarySearchTree1();
		System.out.println("Positive Iterative Test Result: " + identicalBSTIterative(testNode, testNode1));
	}

	@Test
	public void identicalBSTIterativeNegativeTest() {
		TreeNode testNode = populateBinarySearchTree();
		TreeNode testNode2 = populateBinarySearchTree2();
		System.out.println("Negative Iterative Test Result: " + identicalBSTIterative(testNode, testNode2));
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
		binarySearchTree.insertionIterative(rootNode, 52);
		binarySearchTree.insertionIterative(rootNode, 31);
		BinarySearchTreeInsertion inst = new BinarySearchTreeInsertion();
		inst.inOrderRecursive(rootNode);
		System.out.println();
		return rootNode;
	}

	private TreeNode populateBinarySearchTree2() {
		BinarySearchTreeInsertion binarySearchTree = new BinarySearchTreeInsertion();
		TreeNode rootNode = null;
		rootNode = binarySearchTree.insertionIterative(rootNode, 10);
		binarySearchTree.insertionIterative(rootNode, 5);
		binarySearchTree.insertionIterative(rootNode, 30);
		binarySearchTree.insertionIterative(rootNode, 2);
		binarySearchTree.insertionIterative(rootNode, 41);
		binarySearchTree.insertionIterative(rootNode, 42);
		binarySearchTree.insertionIterative(rootNode, 8);
		binarySearchTree.insertionIterative(rootNode, 11);
		binarySearchTree.insertionIterative(rootNode, 9);
		BinarySearchTreeInsertion inst = new BinarySearchTreeInsertion();
		inst.inOrderRecursive(rootNode);
		System.out.println();
		return rootNode;
	}
}
