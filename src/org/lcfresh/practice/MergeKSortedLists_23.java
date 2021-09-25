package org.lcfresh.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MergeKSortedLists_23 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;

    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(a -> a.val));

    for (ListNode listNode : lists) {
      ListNode current = listNode;
      while (current != null) {
        priorityQueue.add(current);
        current = current.next;
      }
    }

    ListNode current = null;
    while (!priorityQueue.isEmpty()) {
      if (head == null) {
        head = new ListNode(priorityQueue.poll().val);
        current = head;
      } else {
        current.next = new ListNode(priorityQueue.poll().val);
        current = current.next;
      }
    }

    return head;
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
