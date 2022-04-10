package org.twentytwentytwo.practice;

import org.junit.Test;

public class DeletetheMiddleNodeofaLinkedList_2095 {

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

  public ListNode deleteMiddle(ListNode head) {
    if (head.next == null) {
      return head.next;
    }

    int count = 0;

    ListNode current = head;

    while (current != null) {
      count++;
      current = current.next;
    }

    count = count / 2;

    int index = 0;
    current = head;

    ListNode prev = null;

    while (index < count) {
      prev = current;
      current = current.next;
      index++;
    }
    prev.next = current.next;

    return head;

  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    //listNode.next.next = new ListNode(3);
    //listNode.next.next.next = new ListNode(4);
//    listNode.next.next.next.next = new ListNode(1);
//    listNode.next.next.next.next.next = new ListNode(2);
//    listNode.next.next.next.next.next.next = new ListNode(6);

    deleteMiddle(listNode);
  }
}
