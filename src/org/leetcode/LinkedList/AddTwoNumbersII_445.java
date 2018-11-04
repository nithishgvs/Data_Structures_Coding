package org.leetcode.LinkedList;

import java.util.Stack;
import org.junit.Test;

public class AddTwoNumbersII_445 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    ListNode current = l1;
    while (current != null) {
      stack1.add(current.val);
      current = current.next;
    }
    current = l2;
    while (current != null) {
      stack2.add(current.val);
      current = current.next;
    }

    int carry = 0;
    ListNode outHead = null;
    ListNode outCurrent = null;
    StringBuffer sb = new StringBuffer();

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      int out = 0;
      if (!stack1.isEmpty()) {
        out += stack1.pop();
      }
      if (!stack2.isEmpty()) {
        out += stack2.pop();
      }
      if (carry == 1) {
        out++;
      }
      if (out > 9) {
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(out % 10);
    }
    if(carry==1)
      sb.append(1);

    for (char ch : sb.reverse().toString().toCharArray()) {
      if (outHead == null) {
        outHead = new ListNode(Integer.parseInt(Character.toString(ch)));
        outCurrent = outHead;
      } else {
        outCurrent.next = new ListNode(Integer.parseInt(Character.toString(ch)));
        outCurrent = outCurrent.next;
      }

    }

    return outHead;
  }

  @Test
  public void testAddTwoNumbers() {
    ListNode l1 = new ListNode(7);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l1.next.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    addTwoNumbers(l1, l2);
  }

  @Test
  public void testAddTwoNumbers2() {
    ListNode l1 = new ListNode(7);

    ListNode l2 = new ListNode(5);

    addTwoNumbers(l1, l2);
  }



}
