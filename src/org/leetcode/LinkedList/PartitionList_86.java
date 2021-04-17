package org.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PartitionList_86 {


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

  public ListNode partition(ListNode head, int x) {

    ListNode newHead = null;

    ListNode current = head;

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    while (current != null) {
      if (current.val < x) {
        list1.add(current.val);
      } else {
        list2.add(current.val);
      }
      current = current.next;
    }

    for (int i = 0; i < list1.size(); i++) {
      if (newHead == null) {
        newHead = new ListNode(list1.get(i));
        current = newHead;
      } else {
        current.next = new ListNode(list1.get(i));
        current = current.next;
      }
    }

    for (int i = 0; i < list2.size(); i++) {
      if (newHead == null) {
        newHead = new ListNode(list2.get(i));
        current = newHead;
      } else {
        current.next = new ListNode(list2.get(i));
        current = current.next;
      }
    }

    return newHead;

  }


  @Test
  public void test1() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);
    partition(head, 3);
  }

  @Test
  public void test2() {
    ListNode head = new ListNode(2);
    head.next = new ListNode(3);
    head.next.next = new ListNode(1);
    partition(head, 1);
  }
}
