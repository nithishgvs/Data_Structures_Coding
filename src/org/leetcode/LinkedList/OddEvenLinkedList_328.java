package org.leetcode.LinkedList;

public class OddEvenLinkedList_328 {

  public ListNode oddEvenList(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode current = head;
    ListNode nextNext = null;
    ListNode dummy = head.next;

    while (current != null) {

      if (dummy != null) {
        current.next = dummy.next;
        if (current.next != null) {
          dummy.next = current.next.next;
        }
      }

    }
    return null;
  }

}
