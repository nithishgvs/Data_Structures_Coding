package org.practice.io.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MergeTwoSortedLists_21 {

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


  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode newHead = null;

    ListNode current1 = list1;
    ListNode current2 = list2;

    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(a -> a.val));

    while (current1 != null) {
      priorityQueue.add(current1);
      current1 = current1.next;
    }

    while (current2 != null) {
      priorityQueue.add(current2);
      current2 = current2.next;
    }
    ListNode current = null;
    while (!priorityQueue.isEmpty()) {
      if (newHead == null) {
        newHead = new ListNode(priorityQueue.poll().val);
        current = newHead;
      } else {
        current.next = new ListNode(priorityQueue.poll().val);
        current = current.next;
      }

    }

    return newHead;
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(4);
    ListNode listNode2 = new ListNode(1);
    listNode2.next = new ListNode(3);
    listNode2.next.next = new ListNode(4);
    mergeTwoLists(listNode, listNode2);
  }

}
