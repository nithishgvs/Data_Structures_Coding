package org.nithishgvs.Binarytree;

/**
 * Binary Tree Node
 * @author nithishgvs
 *
 * @param <T>
 */
public class Node<T> {

	// Getters and Setters
	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public T getData() {
		return data;
	}

	// Constructor
	public Node(T data) {
		this.data = data;
	}

	// Fields
	private T data;
	private Node<T> rightChild;
	private Node<T> leftChild;

}
