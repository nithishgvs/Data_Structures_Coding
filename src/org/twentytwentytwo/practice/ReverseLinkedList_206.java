package org.twentytwentytwo.practice;

import org.junit.Test;

public class ReverseLinkedList_206 {

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


  public ListNode reverseList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy;
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    dummy = current;
    reverseLL(head);
    head.next = null;
    return dummy;

  }

  private void reverseLL(ListNode head) {

    ListNode prev = null;
    ListNode next;
    ListNode current = head;
    while (current != null) {
      if (prev != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      } else {
        prev = current;
        current = current.next;
      }
    }
  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    //listNode.next = new ListNode(2);
    //listNode.next.next = new ListNode(3);
    //listNode.next.next.next = new ListNode(4);
    //listNode.next.next.next.next = new ListNode(5);
    //listNode.next.next.next.next.next = new ListNode(8);
    reverseList(listNode);
  }

}
