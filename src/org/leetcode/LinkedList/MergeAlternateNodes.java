package org.leetcode.LinkedList;

public class MergeAlternateNodes {

	public static NodeSLL<Integer> mergeAlternateNodesTwoLinkedLists(NodeSLL<Integer> headNode1,
			NodeSLL<Integer> headNode2) {
		NodeSLL<Integer> outputHead = null;
		if (headNode1 == null || headNode2 == null) {
			System.out.println("One of the Lists is Null.OOPS! Can't Proceed!!!");
			return outputHead;
		}
		boolean flag = false;
		NodeSLL<Integer> firstCurrent = headNode1;
		NodeSLL<Integer> secondCurrent = headNode2;

		NodeSLL<Integer> outputCurrent = null;

		while (firstCurrent != null || secondCurrent != null) {
			if (!flag && firstCurrent != null) {
				if (outputHead == null) {
					outputHead = new NodeSLL<Integer>(firstCurrent.getData());
					outputCurrent = outputHead;
				} else {
					outputCurrent.setNextNode(new NodeSLL<Integer>(firstCurrent.getData()));
					outputCurrent=outputCurrent.getNextNode();
				}
				firstCurrent = firstCurrent.getNextNode();
				flag = !flag;
			} else if (flag && secondCurrent != null) {
				outputCurrent.setNextNode(new NodeSLL<Integer>(secondCurrent.getData()));
				secondCurrent = secondCurrent.getNextNode();
				outputCurrent=outputCurrent.getNextNode();
				flag = !flag;

			}
		}

		return outputHead;
	}

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll1 = new SingleLLOperations<>();
		NodeSLL<Integer> headNode1 = sll1.insertAtLast(3);
		sll1.insertAtLast(4);
		sll1.insertAtLast(5);
		sll1.insertAtLast(6);
		System.out.println("First List before operation");
		sll1.printSingleLL(headNode1);
		System.out.println();

		SingleLLOperations<Integer> sll2 = new SingleLLOperations<>();
		NodeSLL<Integer> headNode2 = sll2.insertAtLast(100);
		sll2.insertAtLast(200);
		sll2.insertAtLast(300);
		sll2.insertAtLast(400);
		System.out.println("Second List before operation");
		sll2.printSingleLL(headNode2);
		System.out.println();

		System.out.println("After Calling Method");

		sll2.printSingleLL(mergeAlternateNodesTwoLinkedLists(headNode1, headNode2));

	}

}
