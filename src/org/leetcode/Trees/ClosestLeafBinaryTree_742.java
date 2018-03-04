package org.leetcode.Trees;

import org.junit.Test;

public class ClosestLeafBinaryTree_742 {

	public Node<Character> prepareBinaryTree() {
		Node<Character> root = new Node<Character>('A');
		root.setLeftChild(new Node<Character>('B'));
		root.setRightChild(new Node<Character>('C'));
		root.getRightChild().setLeftChild(new Node<Character>('E'));
		root.getRightChild().setRightChild(new Node<Character>('F'));
		root.getRightChild().getLeftChild().setLeftChild(new Node<Character>('G'));
		root.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node<Character>('I'));
		root.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node<Character>('J'));
		root.getRightChild().getRightChild().setRightChild(new Node<Character>('H'));
		root.getRightChild().getRightChild().getRightChild().setLeftChild(new Node<Character>('K'));
		return root;
	}

	@Test
	public void closestLeafBinaryTreeTest() {
		BinarySearchTreeInsertion bst = new BinarySearchTreeInsertion();
		System.out.println("PreOrder traversal of this Output Tree");
		PreOrderTraversalBinaryTree<Character> pre = new PreOrderTraversalBinaryTree<>();
		Node<Character> output = prepareBinaryTree();
		pre.preOrderRecursive(output);
	}

}
