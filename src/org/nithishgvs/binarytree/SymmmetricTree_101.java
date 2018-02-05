package org.nithishgvs.binarytree;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class SymmmetricTree_101 {

	static ArrayList<Integer> al = new ArrayList<>();

	/**
	 * Find if Tree is Symmetric
	 * 
	 * @param treeNode
	 * @return
	 */
	public static boolean isSymmetric(Node<Integer> treeNode) {
		inOrderRecursive(treeNode);
		ArrayList<Integer> cloneAl = new ArrayList<>(al);
		Collections.reverse(al);
		if (al.equals(cloneAl)) {
			return true;
		}
		return false;
	}

	/**
	 * left->root->right
	 * 
	 * @param root
	 */
	public static void inOrderRecursive(Node<Integer> root) {
		if (root == null)
			return;
		inOrderRecursive(root.getLeftChild());
		al.add(root.getData());
		inOrderRecursive(root.getRightChild());
	}

	public Node<Integer> prepareBinaryTree1() {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeftChild(new Node<Integer>(2));
		root.setRightChild(new Node<Integer>(2));
		root.getLeftChild().setLeftChild(new Node<Integer>(3));
		root.getLeftChild().setRightChild(new Node<Integer>(4));
		root.getRightChild().setLeftChild(new Node<Integer>(4));
		root.getRightChild().setRightChild(new Node<Integer>(3));
		return root;
	}

	public Node<Integer> prepareBinaryTree2() {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeftChild(new Node<Integer>(2));
		root.setRightChild(new Node<Integer>(2));
		root.getLeftChild().setRightChild(new Node<Integer>(3));
		root.getRightChild().setRightChild(new Node<Integer>(3));
		return root;
	}

	@Test
	public void testSymmetricCase1() {
		Node<Integer> root = prepareBinaryTree1();
		inOrderRecursive(root);
		System.out.println("Scenario1 output : " + isSymmetric(root));
	}

	@Test
	public void testSymmetricCase2() {
		Node<Integer> root = prepareBinaryTree2();
		inOrderRecursive(root);
		System.out.println("Scenario2 output : " + isSymmetric(root));
	}

}
