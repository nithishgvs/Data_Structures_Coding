package org.leetcode.LinkedList;

import org.junit.Test;

public class RemoveNthNodeFromEndofList_19 {

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

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode current = head;
    int count = 0;

    while (current != null) {
      count++;
      current = current.next;
    }

    int newCount = 0;

    current = head;

    ListNode prev = null;

    while (current != null) {
      if (newCount == count - n) {
        if (prev != null) {
          prev.next = current.next;
        } else {
          if (current.next == null) {
            head = null;
          } else {
            current = current.next;
            head = current;
          }
        }
        break;
      }
      newCount++;
      prev = current;
      current = current.next;

    }

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
    removeNthFromEnd(null, 2);
  }
}
