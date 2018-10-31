package org.leetcode.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_234 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public boolean isPalindrome(ListNode head) {
    ListNode current = head;
    int size = 0;
    while (current != null) {
      current = current.next;
      size++;
    }
    Stack<Integer> stack = new Stack<>();
    int cut = 0;
    current = head;
    while (cut < (size / 2)) {
      stack.add(current.val);
      current = current.next;
      cut++;
    }

    if (size % 2 != 0) {
      current = current.next;
    }

    while (current != null) {
      if (stack.pop() != current.val) {
        return false;
      }
      current = current.next;
    }
    return true;
  }

}
