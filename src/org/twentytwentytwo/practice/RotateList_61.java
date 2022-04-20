package org.twentytwentytwo.practice;

import org.junit.Test;

public class RotateList_61 {

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


  public ListNode rotateRight(ListNode head, int k) {

    if (head == null || head.next == null || k == 0) {
      return head;
    }

    ListNode current = head;
    ListNode prev = null;

    int count = 0;

    while (current != null) {
      count++;
      current = current.next;
    }

    k = k % count;

    current = head;
    while (k > 0) {
      while (current.next != null) {
        prev = current;
        current = current.next;
      }
      prev.next = null;
      current.next = head;
      head = current;
      current = head;
      k--;
    }

    return head;
  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    //listNode.next.next.next.next.next = new ListNode(6);
    ListNode node1 = rotateRight(listNode, 6);
    System.out.println(node1);
  }
}
