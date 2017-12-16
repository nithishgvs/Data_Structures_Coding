package org.nithishgvs.linkedlist;

public class EvenNodesEndLinkedList<T> {

	public void movingEvenNodes(NodeSLL<Integer> headNode) {

		if (headNode == null) {
			return;
		}
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();

		NodeSLL<Integer> current = headNode;
		NodeSLL<Integer> evenListHead = null;
		NodeSLL<Integer> previous = null;

		while (current != null) {
			if (current.getData() % 2 == 0) {
				if (previous != null) {
					previous.setNextNode(current.getNextNode());
					if (evenListHead == null) {
						evenListHead = new NodeSLL<Integer>(current.getData());
					} else {
						NodeSLL<Integer> evenListCurrent = new NodeSLL<Integer>(current.getData());
						evenListCurrent.setNextNode(evenListHead);
						evenListHead = evenListCurrent;
					}
				} else {
					if (evenListHead == null) {
						evenListHead = new NodeSLL<Integer>(current.getData());
					} else {
						NodeSLL<Integer> evenListCurrent = new NodeSLL<Integer>(current.getData());
						evenListCurrent.setNextNode(evenListHead);
						evenListHead = evenListCurrent;
					}
					headNode = current.getNextNode();
					current = current.getNextNode();
					continue;
				}
			}

			previous = current;
			current = current.getNextNode();
		}
		previous.setNextNode(evenListHead);
		System.out.println("After Rearranging");
		sll.printSingleLL(headNode);
	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		NodeSLL<Integer> headNode = sll.insertAtLast(2);
		// sll.insertAtLast(2);
		sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(6);
		sll.insertAtLast(7);

		System.out.println("Before Rearranging");
		sll.printSingleLL(headNode);
		System.out.println();

		EvenNodesEndLinkedList<Integer> evenNode = new EvenNodesEndLinkedList<>();
		evenNode.movingEvenNodes(headNode);

	}

}
