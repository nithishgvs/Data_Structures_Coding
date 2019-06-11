package org.leetcode.LinkedList;

import java.util.PriorityQueue;
import org.junit.Test;

public class MergeKSortedLists_23 {


  public ListNode mergeKLists(ListNode[] lists) {
    ListNode rootNode = null;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (ListNode list : lists) {
      ListNode current = list;
      while (current != null) {
        minHeap.add(current.val);
        current = current.next;
      }
    }

    ListNode current = null;
    while (!minHeap.isEmpty()) {
      if (rootNode == null) {
        rootNode = new ListNode(minHeap.poll());
        current = rootNode;
      } else {
        current.next = new ListNode(minHeap.poll());
        current = current.next;
      }
    }

    return rootNode;
  }


  @Test
  public void testMergeKSortedLists1() {
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(4);
    listNode1.next.next = new ListNode(5);
    ListNode listNode2 = new ListNode(1);
    listNode2.next = new ListNode(3);
    listNode2.next.next = new ListNode(4);
    ListNode listNode3 = new ListNode(2);
    listNode3.next = new ListNode(6);
    ListNode outNode = mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
  }
}
