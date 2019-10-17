package org.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MiddleoftheLinkedList_876 {

  public ListNode middleNode(ListNode head) {

    if (head == null) {
      return head;
    }

    ListNode current = head;
    List<ListNode> list = new ArrayList<>();

    while (current != null) {
      list.add(current);
      current = current.next;
    }

    return list.get(list.size() / 2);

  }

  @Test
  public void test1() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    root.next.next.next.next.next = new ListNode(6);
    System.out.println(middleNode(root).val);
  }

  @Test
  public void test2() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
//    root.next.next = new ListNode(3);
//    root.next.next.next = new ListNode(4);
//    root.next.next.next.next = new ListNode(5);
//    root.next.next.next.next.next = new ListNode(6);
    System.out.println(middleNode(root).val);
  }

}
