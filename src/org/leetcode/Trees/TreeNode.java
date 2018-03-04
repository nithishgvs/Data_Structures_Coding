package org.leetcode.Trees;

public class TreeNode {

	private int data;
	private TreeNode rightChild;
	private TreeNode leftChild;

	// Constructor
	public TreeNode(int data) {
		this.data = data;
	}

	// Setters & Getters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

}
