package org.leetcode.LinkedList;

public class SplitLinkedListIntoTwo<T> {

	@SuppressWarnings("unchecked")
	public void splitLinkedList(NodeSLL<T> headNode) {

		if (headNode == null) {
			System.out.println("No Elements!OOps!");
			return;
		}
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		int size = sll.sizeOfLinkedList((NodeSLL<Integer>) headNode);
		int count = (size / 2) + (size % 2);
		NodeSLL<T> firstHead = headNode;
		@SuppressWarnings("unused")
		NodeSLL<T> secondHead = null;
		int i = 1;
		while (firstHead != null && i < count) {
			firstHead = firstHead.getNextNode();
			i++;
		}
		secondHead = firstHead.getNextNode();
		firstHead.setNextNode(null);
		firstHead = headNode;
	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll = new SingleLLOperations<>();
		NodeSLL<Integer> headNode = sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(6);
		sll.insertAtLast(7);
		SplitLinkedListIntoTwo<Integer> split = new SplitLinkedListIntoTwo<>();
		split.splitLinkedList(headNode);

	}

}
