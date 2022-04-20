package org.twentytwentytwo.practice;

import org.junit.Test;

public class RemoveDuplicatesfromSortedList_83 {


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


  public ListNode deleteDuplicates(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }
    ListNode current = head;

    ListNode prev = null;

    while (current != null) {
      if (prev != null) {
        if (current.val == prev.val) {
          prev.next = current.next;
        } else {
          prev = current;
        }
      } else {
        prev = current;
      }
      current = current.next;
    }

    return head;

  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(3);
    //listNode.next.next.next.next.next = new ListNode(6);
    ListNode node1 = deleteDuplicates(listNode);
    System.out.println(node1);
  }
}
