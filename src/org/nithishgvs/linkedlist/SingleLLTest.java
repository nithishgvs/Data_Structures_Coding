package org.nithishgvs.linkedlist;

public class SingleLLTest {

	public static void main(String[] args) {
		SingleLLOperations<Integer> sll=new SingleLLOperations<>();
		NodeSLL<Integer> headNode=sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(6);
		System.out.println(sll.sizeOfLinkedList(headNode));
		sll.printSingleLL(headNode);
		sll.deleteAtLast(headNode);
		System.out.println();
		sll.printSingleLL(headNode);
		System.out.println();
		sll.findAnElement(4);
		sll.findAnElement(100);

	}

}
