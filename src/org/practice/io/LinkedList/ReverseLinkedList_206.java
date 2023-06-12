package org.practice.io.LinkedList;

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

    return reverseListRecursively(head, null);
  }

  private ListNode reverseListRecursively(ListNode head, ListNode previous) {

    if (head.next == null) {
      head.next = previous;
      return head;
    }

    ListNode current = head.next;
    head.next = previous;
    return reverseListRecursively(current, head);
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    reverseList(listNode);
  }
}
