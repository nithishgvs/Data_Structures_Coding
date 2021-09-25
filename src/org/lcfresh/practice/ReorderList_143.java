package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ReorderList_143 {

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


  public void reorderList2(ListNode head) {
    ListNode current = head;
    List<ListNode> list = new ArrayList<>();
    int size = 0;
    while (current != null) {
      list.add(new ListNode(current.val));
      current = current.next;
      size++;
    }

    if (size == 1) {
      return;
    }
    current = null;

    int currentIndex = 0;
    boolean flag = false;

    int newListSize = 0;

    while (newListSize < size) {
      if (current == null) {
        current = head;
        currentIndex++;
        newListSize++;
        continue;
      }
      if (!flag) {
        ListNode newNode = list.get(list.size() - currentIndex);
        newNode.next = null;
        current.next = newNode;
      } else {
        ListNode newNode = list.get(currentIndex);
        newNode.next = null;
        current.next = newNode;
        currentIndex++;
      }
      flag = !flag;
      newListSize++;
      current = current.next;
    }

  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode current = head;
    ListNode slowPtr = current;
    ListNode fastPtr = current;
    ListNode prev = null;

    while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
      prev = slowPtr;
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    prev.next = null;

    ListNode reverseHead = reverseLinkedList(slowPtr);

    boolean flag = false;
    ListNode temp = current.next;

    while (reverseHead != null) {
      if (!flag) {
        current.next = new ListNode(reverseHead.val);
        reverseHead = reverseHead.next;
        current = current.next;
      } else if (temp != null) {
        current.next = new ListNode(temp.val);
        temp = temp.next;
        current = current.next;
      }
      flag = !flag;
    }
  }


  private ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode next;
    ListNode current = head;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  @Test
  public void test1() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    reorderList(head);
  }
}
