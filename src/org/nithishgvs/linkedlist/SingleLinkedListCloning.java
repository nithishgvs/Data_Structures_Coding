package org.nithishgvs.linkedlist;

public class SingleLinkedListCloning<T> {
    /**
     * Clone of Single Lined List
     * @param headNode
     * @return
     */
	public NodeSLL<T> singleLinkedListClone(NodeSLL<T> headNode) {
		NodeSLL<T> headClone = null;
		if (headNode == null) {
			return null;
		} else {
			NodeSLL<T> current = headNode;
			NodeSLL<T> cloneTemp = null;
			while (current != null) {
				if (headClone == null) {
					headClone = current;
					cloneTemp = headClone;
				} else {
					cloneTemp.setNextNode(current);
					cloneTemp = cloneTemp.getNextNode();
				}
				current = current.getNextNode();
			}

		}
		return headClone;

	}

	public static void main(String[] args) {
		// Created a Single Linked List
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
		// Create Object of SingleLinkedListCloning
		SingleLinkedListCloning<Integer> sllc = new SingleLinkedListCloning<>();
		NodeSLL<Integer> cloneHead = sllc.singleLinkedListClone(headNode);
		sll.printSingleLL(cloneHead);

	}

}
