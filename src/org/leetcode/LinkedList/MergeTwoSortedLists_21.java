package org.leetcode.LinkedList;

import java.util.PriorityQueue;
import org.junit.Test;

public class MergeTwoSortedLists_21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode outNode = null;

    ListNode current = null;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    populateMapWithLinkedList(l1, minHeap);
    populateMapWithLinkedList(l2, minHeap);

    while (minHeap.peek() != null) {
      if (outNode == null) {
        outNode = new ListNode(minHeap.poll());
        current = outNode;
      } else {
        current.next = new ListNode(minHeap.poll());
        current=current.next;
      }
    }

    return outNode;

  }


  private void populateMapWithLinkedList(ListNode listNode, PriorityQueue<Integer> minHeap) {
    ListNode current = listNode;
    while (current != null) {
      minHeap.add(current.val);
      current = current.next;
    }
  }


  @Test
  public void test() {
    ListNode headA = new ListNode(1);
    headA.next = new ListNode(2);
    headA.next.next = new ListNode(4);

    // 1,3,5,7,9,11,13,15,17,19,21

    ListNode headB = new ListNode(1);
    headB.next = new ListNode(3);
    headB.next.next = new ListNode(4);
    ListNode out = mergeTwoLists(headA, headB);
    System.out.println(out);
  }

}
