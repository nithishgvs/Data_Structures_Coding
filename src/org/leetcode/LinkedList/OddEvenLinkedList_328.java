package org.leetcode.LinkedList;

import org.junit.Test;

public class OddEvenLinkedList_328 {

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode oddHead = null;
    ListNode evenHead = null;

    ListNode oddCurrent = null;
    ListNode evenCurrent = null;
    ListNode current = head;

    boolean oddFlag = true;

    while (current != null) {
      if (oddFlag) {
        if (oddHead == null) {
          oddHead = new ListNode(current.val);
          oddCurrent = oddHead;
        } else {
          oddCurrent.next = new ListNode(current.val);
          oddCurrent = oddCurrent.next;
        }
      } else {
        if (evenHead == null) {
          evenHead = new ListNode(current.val);
          evenCurrent = evenHead;
        } else {
          evenCurrent.next = new ListNode(current.val);
          evenCurrent = evenCurrent.next;
        }
      }
      oddFlag = !oddFlag;
      current = current.next;
    }

    oddCurrent.next = evenHead;

    return oddHead;
  }


  @Test
  public void test() {
    ListNode listNode = new ListNode(2);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(5);
    listNode.next.next.next.next = new ListNode(6);
    listNode.next.next.next.next.next = new ListNode(4);
    listNode.next.next.next.next.next.next = new ListNode(7);
    oddEvenList(listNode);
  }


}
