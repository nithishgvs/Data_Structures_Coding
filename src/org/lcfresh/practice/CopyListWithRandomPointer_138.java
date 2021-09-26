package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CopyListWithRandomPointer_138 {

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    Node current = head;

    Map<Node, Node> helperMap = new HashMap<>();

    while (current != null) {
      helperMap.put(current, new Node(current.val));
      current = current.next;
    }

    current = head;

    while (current != null) {
      helperMap.get(current).next = helperMap.get(current.next);
      helperMap.get(current).random = helperMap.get(current.random);
      current = current.next;
    }
    return helperMap.get(head);
  }

  @Test
  public void test1() {
    Node head = new Node(7);
    head.next = new Node(13);
    head.next.random = head;
    head.next.next = new Node(11);
    head.next.next.next = new Node(10);
    head.next.next.next.random = head.next.next;
    head.next.next.next.next = new Node(1);
    head.next.next.next.next.random = head;
    head.next.next.random = head.next.next.next.next;
    copyRandomList(head);

  }


}
