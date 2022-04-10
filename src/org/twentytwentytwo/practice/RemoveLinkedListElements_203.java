package org.twentytwentytwo.practice;

import org.junit.Test;

public class RemoveLinkedListElements_203 {

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

  public ListNode removeElements(ListNode head, int val) {

    if (head == null) {
      return head;
    }

    ListNode current = head;

    ListNode prev = null;

    while (current != null) {
      if (head.val == val) {
        head = head.next;
        current = head;
      } else if (current.val == val) {
        prev.next = current.next;
        current = current.next;
      } else {
        prev = current;
        current = current.next;
      }
    }

    return head;
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(2);
    listNode.next = new ListNode(3);
    listNode.next.next = new ListNode(4);
    listNode.next.next.next = new ListNode(5);
    listNode.next.next.next.next = new ListNode(6);
    listNode.next.next.next.next.next = new ListNode(7);

    ListNode listNode1 = removeElements(listNode, 2);
  }
}
