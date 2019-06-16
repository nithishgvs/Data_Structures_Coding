package org.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LinkedListComponents_817 {


  public int numComponents(ListNode head, int[] G) {
    int out = 0;

    Set<Integer> set = new HashSet<>();

    for (int e : G) {
      set.add(e);
    }

    ListNode current = head;
    boolean flag = false;
    while (current != null) {
      if (set.contains(current.val)) {
        if (!flag) {
          flag = true;
          out++;
        }
      } else {
        flag = false;
      }
      current = current.next;
    }

    return out;
  }


  @Test
  public void test() {
    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    numComponents(head, new int[]{0, 3, 1, 4});
  }

  @Test
  public void test1() {
    ListNode head = new ListNode(0);
    head.next = new ListNode(2);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(1);
    numComponents(head, new int[]{3, 2, 4});
  }


}
