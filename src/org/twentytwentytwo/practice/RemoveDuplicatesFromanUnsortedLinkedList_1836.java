package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RemoveDuplicatesFromanUnsortedLinkedList_1836 {


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


  public ListNode deleteDuplicatesUnsorted(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    Map<Integer, Integer> map = new HashMap<>();

    ListNode current = head;

    while (current != null) {
      Integer val = map.getOrDefault(current.val, 0);
      map.put(current.val, ++val);
      current = current.next;
    }

    ListNode prev = null;

    current = head;

    while (current != null) {
      if (map.get(current.val) > 1) {
        if (prev != null) {
          prev.next = current.next;
        } else {
          head = current.next;
        }
      } else {
        prev = current;
      }
      current = current.next;
    }

    return head;

  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(3);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(1);
    listNode.next.next.next.next = new ListNode(3);
    listNode.next.next.next.next.next = new ListNode(2);
    listNode.next.next.next.next.next.next = new ListNode(4);
    ListNode node1 = deleteDuplicatesUnsorted(listNode);
    System.out.println(node1);
  }
}
