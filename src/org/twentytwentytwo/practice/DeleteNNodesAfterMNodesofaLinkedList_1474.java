package org.twentytwentytwo.practice;

import org.junit.Test;

public class DeleteNNodesAfterMNodesofaLinkedList_1474 {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }

  public ListNode deleteNodes(ListNode head, int m, int n) {

    int i = m - 1;
    int j = n;

    ListNode current = head;

    while (current != null) {
      while (i > 0 && current != null) {
        current = current.next;
        i--;
      }
      ListNode temp = current;
      while (j > 0 && temp != null) {
        temp = temp.next;
        j--;
      }

      ListNode newTemp = temp;
      if (newTemp != null) {
        current.next = temp.next;
        current = newTemp.next;
      } else if (current != null) {
        current.next = null;
        current = current.next;
      }
      i = m - 1;
      j = n;
    }

    return head;
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(6);
    listNode.next = new ListNode(3);
    listNode.next.next = new ListNode(5);
    listNode.next.next.next = new ListNode(6);
    listNode.next.next.next.next = new ListNode(2);
    listNode.next.next.next.next.next = new ListNode(8);
    listNode.next.next.next.next.next.next = new ListNode(9);
    listNode.next.next.next.next.next.next.next = new ListNode(2);
    listNode.next.next.next.next.next.next.next.next = new ListNode(3);
    listNode.next.next.next.next.next.next.next.next.next = new ListNode(4);
    //listNode.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
    //listNode.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
    //listNode.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);
    ListNode res = deleteNodes(listNode, 2, 1);
    ListNode current = res;
    while (current != null) {
      System.out.print(current.val + "->");
      current = current.next;
    }
  }
}
