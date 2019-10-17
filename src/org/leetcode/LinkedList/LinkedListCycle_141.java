package org.leetcode.LinkedList;

import org.junit.Test;

public class LinkedListCycle_141 {

  public boolean hasCycle(ListNode head) {

    if (head == null || head.next == null) {
      return false;
    }

    ListNode firstPtr = head;
    ListNode secondPtr = head.next;

    while (firstPtr != secondPtr) {
      if (secondPtr == null || secondPtr.next == null) {
        return false;
      }

      firstPtr = firstPtr.next;
      secondPtr = secondPtr.next.next;
    }
    return true;
  }


  @Test
  public void test() {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = head.next;
    System.out.println(hasCycle(head));

  }

  @Test
  public void test1() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    System.out.println(hasCycle(head));

  }

}
