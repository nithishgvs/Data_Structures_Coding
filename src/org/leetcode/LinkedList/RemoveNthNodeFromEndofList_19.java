package org.leetcode.LinkedList;

import org.junit.Test;

public class RemoveNthNodeFromEndofList_19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {


    return head;

  }


  @Test
  public void test1() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    removeNthFromEnd(head, 3);
  }

  @Test
  public void test2() {
    ListNode head = new ListNode(1);
    removeNthFromEnd(head, 1);
  }

  @Test
  public void test3() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    removeNthFromEnd(head, 2);
  }
}
