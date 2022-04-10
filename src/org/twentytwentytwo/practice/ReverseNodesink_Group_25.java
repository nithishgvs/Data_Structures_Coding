package org.twentytwentytwo.practice;

import org.junit.Test;

public class ReverseNodesink_Group_25 {

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

    while (count < k - 1) {
      current = current.next;
      if (current == null) {
        return head;
      }
      count++;
    }

    ListNode next = current.next;
    current.next = null;
    ListNode dummy = reverseLL(head);
    ListNode last = head;
    current = next;

    count = 0;
    ListNode newTemp;

    while (current != null) {
      while (count < k - 1) {
        current = current.next;
        if (current == null) {
          last.next = next;
          return dummy;
        }
        count++;
      }
      count = 0;
      newTemp = current.next;
      current.next = null;
      last.next = reverseLL(next);
      last = next;
      current = newTemp;
      next = newTemp;
    }

    return dummy;
  }


  public ListNode reverseLL(ListNode head) {

    ListNode current = head;
    ListNode prev = null;
    ListNode next;

    while (current != null) {
      if (prev != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      } else {
        prev = current;
        current = current.next;
        prev.next = null;
      }
    }

    return prev;

  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(6);
    ListNode node1 = reverseKGroup(listNode, 4);
    //ListNode node1 = reverseLL(listNode);
    System.out.println(node1);
  }



}
