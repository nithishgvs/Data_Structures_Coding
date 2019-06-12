package org.leetcode.LinkedList;

import org.junit.Test;

public class SwapNodesinPairs_24 {


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
  public void testSwapPairs() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    //root.next.next.next.next = new ListNode(5);
    swapPairs(root);
  }
}
