package org.leetcode.LinkedList;

import org.junit.Test;

public class AddTwoNumbers_2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode current = null;
    ListNode head = null;

    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {

      int sum = 0;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      if (carry != 0) {
        sum += carry;
      }

      carry = sum / 10;
      sum = sum % 10;

      if (current == null) {
        current = new ListNode(sum);
        head = current;
      } else {
        ListNode temp = new ListNode(sum);
        current.next = temp;
        current = current.next;
      }

    }

    return head;
  }


  @Test
  public void test() {
    ListNode listNode1 = new ListNode(3);
    listNode1.next = new ListNode(4);
    listNode1.next.next = new ListNode(2);
    ListNode listNode2 = new ListNode(4);
    listNode2.next = new ListNode(6);
    listNode2.next.next = new ListNode(5);
    addTwoNumbers(listNode1, listNode2);
  }

}
