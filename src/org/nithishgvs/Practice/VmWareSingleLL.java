package org.nithishgvs.Practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class VmWareSingleLL {

  class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;
  }


  public SinglyLinkedListNode test(SinglyLinkedListNode l1, SinglyLinkedListNode l2, int x, int y) {

    Map<Integer, SinglyLinkedListNode> map = new HashMap<>();

    int index = 0;

    SinglyLinkedListNode current = l1;

    while (current.next != null) {
      map.put(++index, current);
      current = current.next;
    }

    SinglyLinkedListNode current2 = l2;

    while (current2.next != null) {
      current2 = current2.next;
    }

    SinglyLinkedListNode prev = map.get(x - 1);
    if (prev == null) {
      if (l1.next == null) {
        l1 = l2;
      } else {
        prev = l1.next;

      }
    } else {
      prev.next = null;
      prev.next = l2;
      SinglyLinkedListNode next = map.get(y + 1);
      current2.next = next;
    }

    return l1;
  }

  @Test
  public void test() {
    SinglyLinkedListNode l1 = new SinglyLinkedListNode();
    l1.data = 1;
    l1.next = new SinglyLinkedListNode();
    l1.next.data = 2;
    l1.next.next = new SinglyLinkedListNode();
    l1.next.next.data = 3;
    l1.next.next.next = new SinglyLinkedListNode();
    l1.next.next.next.data = 4;
    l1.next.next.next.next = new SinglyLinkedListNode();
    l1.next.next.next.next.data = 5;
    l1.next.next.next.next.next = new SinglyLinkedListNode();
    l1.next.next.next.next.next.data = 6;

    SinglyLinkedListNode l2 = new SinglyLinkedListNode();
    l2.data = 7;
    l2.next = new SinglyLinkedListNode();
    l2.next.data = 8;
    l2.next.next = new SinglyLinkedListNode();
    l2.next.next.data = 9;

    SinglyLinkedListNode node = test(l1, l2, 1, 1);
    SinglyLinkedListNode current = node;

    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }

  }


}
