package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LinkedListCycleII_142 {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle2(ListNode head) {

    ListNode curr = head;

    while (curr != null) {
      curr.val = 1000000;
      if (curr.next != null && curr.next.val == 1000000) {
        return curr.next;
      }
      curr = curr.next;

    }
    return null;

  }

  public ListNode detectCycle(ListNode head) {

    ListNode curr = head;
    Map<ListNode, Integer> map = new HashMap<>();
    while (curr != null) {
      int value = map.getOrDefault(curr, 0);
      value = value+1;
      map.put(curr, value);
      if (value > 1) {
        return curr;
      }
      curr = curr.next;
    }
    return null;

  }

  @Test
  public void test1() {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = head.next;
    System.out.println(detectCycle(head).val);
  }


  @Test
  public void test2() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    System.out.println(detectCycle(head));
  }

}
