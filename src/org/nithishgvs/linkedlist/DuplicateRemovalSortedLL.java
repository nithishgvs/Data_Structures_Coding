package org.nithishgvs.linkedlist;

public class DuplicateRemovalSortedLL<T> {
	/**
	 * Remove Duplicates from Sorted Linked List
	 * 
	 * @param headNode
	 * @return
	 */
	public NodeSLL<Integer> duplicateRemoval(NodeSLL<Integer> headNode) {
		NodeSLL<Integer> current = headNode;
		NodeSLL<Integer> previous = null;
		boolean dupFound = false;
		while (current != null) {
			if (previous != null && current.getData() == previous.getData() && !dupFound) {
				previous.setNextNode(current.getNextNode());
				dupFound = true;
				current = previous;
				current = current.getNextNode();
			}
			if (!dupFound) {
				previous = current;
				current = current.getNextNode();
			}
			dupFound = false;
		}
		return headNode;
	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		System.out.println();
		SortedLinkedList<Integer> sortedsll = new SortedLinkedList<>();
		sortedsll.insertSortedLinkedList(4);
		sortedsll.insertSortedLinkedList(5);
		sortedsll.insertSortedLinkedList(16);
		sortedsll.insertSortedLinkedList(27);
		sortedsll.insertSortedLinkedList(8);
		sortedsll.insertSortedLinkedList(8);
		sortedsll.insertSortedLinkedList(8);
		sortedsll.insertSortedLinkedList(16);
		sortedsll.insertSortedLinkedList(5);

		NodeSLL<Integer> headNode = sortedsll.insertSortedLinkedList(0);
		sortedsll.insertSortedLinkedList(1);
		System.out.println("Before Sorting");
		sll.printSingleLL(headNode);

		// Calling Duplicate Method
		System.out.println();
		System.out.println("After Sorting");
		DuplicateRemovalSortedLL<Integer> dup = new DuplicateRemovalSortedLL<>();
		dup.duplicateRemoval(headNode);
		sll.printSingleLL(headNode);

	}

}
