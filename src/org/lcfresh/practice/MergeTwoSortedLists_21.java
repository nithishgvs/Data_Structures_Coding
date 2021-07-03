package org.lcfresh.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MergeTwoSortedLists_21 {


  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }


  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(a -> a.val));

    ListNode current = l1;

    while (current != null) {
      priorityQueue.add(current);
      current = current.next;
    }

    current = l2;

    while (current != null) {
      priorityQueue.add(current);
      current = current.next;
    }

    ListNode result = null;
    current = null;

    while (!priorityQueue.isEmpty()) {
      ListNode polled = priorityQueue.poll();
      ;
      if (result == null) {
        result = new ListNode(polled.val);
        current = result;
      } else {
        current.next = new ListNode(polled.val);
        current = current.next;
      }
    }

    return result;
  }

  @Test
  public void test() {
    ListNode headA = new ListNode(-10);
    headA.next = new ListNode(-10);
    headA.next.next = new ListNode(-9);
    headA.next.next.next = new ListNode(-4);
    headA.next.next.next.next = new ListNode(1);
    headA.next.next.next.next.next = new ListNode(6);
    headA.next.next.next.next.next.next = new ListNode(6);

    // 1,3,5,7,9,11,13,15,17,19,21

    ListNode headB = new ListNode(-7);
//    headB.next = new ListNode(3);
//    headB.next.next = new ListNode(4);
    ListNode out = mergeTwoLists(headA, headB);
    System.out.println(out);
  }

}
