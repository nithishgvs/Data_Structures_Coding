package org.twentytwentytwo.practice;

import org.junit.Test;

public class SwapNodesinPairs_24 {

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


  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    if (head != null && head.next != null) {
      int  temp = head.val;
      ListNode next = head.next.next;
      head = new ListNode(head.next.val);
      head.next = new ListNode(temp);
      head.next.next = swapPairs(next);
    }

    return head;

  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    //listNode.next.next.next.next = new ListNode(5);
    //listNode.next.next.next.next.next = new ListNode(6);
    ListNode node1 = swapPairs(listNode);
    System.out.println(node1);
  }
}
