package org.leetcode.LinkedList;

public class AlternateSplitList<T> {
	/**
	 * Divide given Linked List into two lists of Aletrnate Elements
	 * 
	 * @param headNode
	 */
	@SuppressWarnings("null")
	public void alternateSplitting(NodeSLL<Integer> headNode) {
		NodeSLL<Integer> firstListHead = null;
		NodeSLL<Integer> secondListHead = null;

		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		if (headNode == null && sll.sizeOfLinkedList(headNode) == 1) {
			return;
		}
		NodeSLL<Integer> current = headNode;
		boolean flag = false;
		NodeSLL<Integer> firstCurrent = null;
		NodeSLL<Integer> secondCurrent = null;
		while (current != null) {
			if (!flag) {
				if (firstListHead == null) {
					firstListHead = new NodeSLL<Integer>(current.getData());
					firstCurrent = firstListHead;
				} else {
					firstCurrent.setNextNode(new NodeSLL<Integer>(current.getData()));
					firstCurrent = firstCurrent.getNextNode();
				}
			} else {
				if (secondListHead == null) {
					secondListHead = new NodeSLL<Integer>(current.getData());
					secondCurrent = secondListHead;
				} else {
					secondCurrent.setNextNode(new NodeSLL<Integer>(current.getData()));
					secondCurrent = secondCurrent.getNextNode();
				}
			}
			flag = !flag;
			current = current.getNextNode();
		}
		sll.printSingleLL(firstListHead);
		System.out.println();
		sll.printSingleLL(secondListHead);

	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		NodeSLL<Integer> headNode = sll.insertAtLast(1);
		sll.insertAtLast(2);
		sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(6);
		sll.insertAtLast(7);

		System.out.println("Before Rearranging");
		sll.printSingleLL(headNode);
		System.out.println();
		System.out.println("After Rearranging");

		AlternateSplitList<Integer> alternate = new AlternateSplitList<>();
		alternate.alternateSplitting(headNode);

	}

}
