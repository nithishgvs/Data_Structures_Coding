package org.leetcode.LinkedList;

public class SingleLinkedListPop<T> {

	/**
	 * Pop element at Head of a Single Linked List
	 * 
	 * @param head
	 * @return
	 */
	public NodeSLL<T> SingleLLPopOperation(NodeSLL<T> head) {
		if (head == null) {
			System.out.println("Single Linked List is Empty!");
			return null;
		}
		System.out.println("Data of element which got popped: " + head.getData());
		head = head.getNextNode();
		return head;
	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		NodeSLL<Integer> headNode = sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(6);
		sll.insertAtLast(7);
		sll.insertAtLast(8);
		sll.insertAtLast(9);
		sll.insertAtLast(10);
		sll.printSingleLL(headNode);
		System.out.println();
		SingleLinkedListPop<Integer> sllpop = new SingleLinkedListPop<>();
		NodeSLL<Integer> newNode = sllpop.SingleLLPopOperation(headNode);
		sll.printSingleLL(newNode);
	}

}
