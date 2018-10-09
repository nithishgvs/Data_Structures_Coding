package org.leetcode.LinkedList;

public class MoveFirstNodeToAnotherList{

	public void moveFirstNodesToAnotherList(NodeSLL<Integer> headNode1, NodeSLL<Integer> headNode2) {
      if(headNode1==null ||headNode2==null){
    	  return;
      }
      
      NodeSLL<Integer> headToBeMoved=headNode1;
      headNode1=headNode1.getNextNode();
      
      SingleLLOperations<Integer> sll = new SingleLLOperations<>();
      //After moving first list head node
      System.out.println("First List after operation");
      sll.printSingleLL(headNode1);
      System.out.println();
      
      headToBeMoved.setNextNode(headNode2);
      headNode2=headToBeMoved;
      System.out.println("Second List after operation");
      sll.printSingleLL(headNode2);
      
      
    
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
		
		MoveFirstNodeToAnotherList move=new MoveFirstNodeToAnotherList();
		move.moveFirstNodesToAnotherList(headNode1, headNode2);
	}

}
