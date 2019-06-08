package org.leetcode.Trees;

public class TreeNodeCustom {

	private int data;
	private TreeNodeCustom rightChild;
	private TreeNodeCustom leftChild;

	// Constructor
	public TreeNodeCustom(int data) {
		this.data = data;
	}

	// Setters & Getters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNodeCustom getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNodeCustom rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNodeCustom getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNodeCustom leftChild) {
		this.leftChild = leftChild;
	}

}
