package org.lcfresh.practice;


import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RemoveNthNodeFromEndofList_19 {

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

  public ListNode removeNthFromEnd(ListNode head, int n) {

    Map<Integer, ListNode> helperMap = new HashMap<>();
    ListNode current = head;

    int value = 1;

    while (current != null) {
      helperMap.put(value, current);
      current = current.next;
      value++;
    }

    if (helperMap.size() - n == 0) {
      return head.next;
    }
    ListNode listNode = helperMap.get(helperMap.size() - n);
    ListNode next = listNode.next;
    listNode.next = next.next;

    return head;

  }

  @Test
  public void test1() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    removeNthFromEnd(head, 2);
  }

  @Test
  public void test2() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    removeNthFromEnd(head, 2);
  }


}
