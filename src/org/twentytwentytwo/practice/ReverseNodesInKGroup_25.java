package org.twentytwentytwo.practice;

import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=acJEBQiFPoY
 */

public class ReverseNodesInKGroup_25 {

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

  public ListNode reverseKGroup(ListNode head, int k) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode current = head;
    int count = 0;

    while (count != k - 1) {
      if (current.next == null) {
        return head;
      }
      current = current.next;
      count++;
    }
    ListNode next = current.next;
    current.next = null;
    ListNode last = head;
    ListNode dummy = reverseLL(last);
    last.next = null;

    count = 0;
    ListNode tempHead = next;
    //dummy head is available now

    while (tempHead != null) {
      while (count != k - 1) {
        if (tempHead.next == null) {
          last.next = next;
          return dummy;
        }
        tempHead = tempHead.next;
        count++;
      }
      current = tempHead.next;
      tempHead.next = null;
      last.next = reverseLL(next);
      next.next = null;
      last = next;
      tempHead = current;
      next = current;
      count = 0;
    }

    return dummy;

  }


  private ListNode reverseLL(ListNode head) {
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
    head = prev;
    return head;
  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(6);
    ListNode node1 = reverseKGroup(listNode, 2);
    System.out.println(node1);
  }


}
