package org.leetcode.LinkedList;

import java.util.Stack;
import org.junit.Test;

public class PlusOneLinkedList_369 {


  public ListNode plusOne(ListNode head) {

    ListNode newHead = null;

    if (head == null) {
      return head;
    }

    ListNode current = head;
    Stack<Integer> stack = new Stack<>();

    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }

    boolean carry = false;

    int elem;

    while (!stack.isEmpty()) {
      elem = stack.pop();
      if (newHead == null) {
        elem = elem + 1;
        newHead = new ListNode(elem % 10);
        carry = (elem / 10 == 1);
        current = newHead;
      } else {
        if (carry) {
          elem = elem + 1;
        }
        current.next = new ListNode(elem % 10);
        carry = (elem / 10 == 1);
        current = current.next;
      }

    }

    if (carry) {
      current.next = new ListNode(1);
    }

    return reverse(newHead);

  }

  private ListNode reverse(ListNode newHead) {

    if (newHead == null || newHead.next == null) {
      return newHead;
    }
    ListNode current = newHead;
    ListNode prev = null;
    ListNode next = null;

    while (current != null) {
      next = new ListNode(current.val);
      if (prev != null) {
        next.next = prev;
      }
      prev = next;
      current = current.next;
    }

    return prev;
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(9);
    listNode.next = new ListNode(9);
    listNode.next.next = new ListNode(9);
    plusOne(listNode);
  }


}
