package org.nithishgvs.linkedlist;

public class SortedLinkedList<T> {

	NodeSLL<Integer> headNode;

	/**
	 * Insertion in a Sorted Linked List
	 * 
	 * @param data
	 * @return
	 */
	public NodeSLL<Integer> insertSortedLinkedList(Integer data) {
		if (headNode == null) {
			headNode = new NodeSLL<Integer>(data);
			return headNode;
		}
		if (data < headNode.getData()) {
			NodeSLL<Integer> temp = new NodeSLL<Integer>(data);
			temp.setNextNode(headNode);
			headNode = temp;
			return headNode;
		}

		NodeSLL<Integer> current = headNode;
		NodeSLL<Integer> previous = null;

		while (current != null && current.getData() < data) {
			previous = current;
			current = current.getNextNode();
		}
		NodeSLL<Integer> temp = new NodeSLL<Integer>(data);
		previous.setNextNode(temp);
		temp.setNextNode(current);
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
		
		
		NodeSLL<Integer> headnode = sortedsll.insertSortedLinkedList(0);
		sortedsll.insertSortedLinkedList(1);
		sll.printSingleLL(headnode);

	}

}
