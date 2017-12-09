package org.nithishgvs.linkedlist;

public class SingleLLOperations<T> {

	private NodeSLL<T> headNode;

	/**
	 * Insertion after head node in a Single Linked List
	 * 
	 * @param data
	 * @return
	 */
	public NodeSLL<T> insertAtFirst(T data) {
		if (headNode == null) {
			headNode = new NodeSLL<T>(data);
		} else {
			NodeSLL<T> temp = headNode.getNextNode();
			NodeSLL<T> newNode = new NodeSLL<T>(data);
			headNode.setNextNode(newNode);
			newNode.setNextNode(temp);
		}
		return headNode;
	}

	/**
	 * Print Elements of a Single Linked List
	 * 
	 * @param headNode
	 */
	public void printSingleLL(NodeSLL<T> headNode) {
		if (headNode == null) {
			System.out.println("Single Linked List is Empty!");
			return;
		} else {
			NodeSLL<T> temp = headNode;
			while (temp != null) {
				System.out.print(temp.getData() + "->");
				temp = temp.getNextNode();
			}
		}
	}

	/**
	 * Insert Element at the end of Single Linked List
	 * 
	 * @param data
	 * @return
	 */
	public NodeSLL<T> insertAtLast(T data) {
		if (headNode == null) {
			headNode = new NodeSLL<T>(data);
		} else {
			NodeSLL<T> current = headNode;
			while (current.getNextNode() != null) {
				current = current.getNextNode();
			}
			current.setNextNode(new NodeSLL<T>(data));
		}
		return headNode;
	}

	/**
	 * Delete Element after Head in Single Linked List
	 * 
	 * @param headNode
	 */
	public void deleteAtFirst(NodeSLL<T> headNode) {
		if (headNode == null) {
			System.out.println("No Elements in Single Linked List!");
		} else {
			headNode.setNextNode(headNode.getNextNode().getNextNode());
		}
	}

	/**
	 * Delete Element from Last in Single Linked List
	 * 
	 * @param headNode
	 */
	public void deleteAtLast(NodeSLL<T> headNode) {
		if (headNode == null) {
			System.out.println("No Elements in Single Linked List!");
		} else {
			NodeSLL<T> current = headNode;
			NodeSLL<T> previous = null;
			while (current.getNextNode() != null) {
				previous = current;
				current = current.getNextNode();
			}
			previous.setNextNode(null);
		}
	}

	/**
	 * Find an ELement in Single Linked List
	 * 
	 * @param data
	 */
	public void findAnElement(T data) {
		if (headNode == null) {
			System.out.println("No Elements in Single Linked List!");
		} else {
			NodeSLL<T> current = headNode;
			while (current != null) {
				if (current.getData() == data) {
					System.out.println("Hurray....Element Found!");
					return;
				}
				current = current.getNextNode();
			}
		}
		System.out.println("OOps!Element Not found!");
	}

}
