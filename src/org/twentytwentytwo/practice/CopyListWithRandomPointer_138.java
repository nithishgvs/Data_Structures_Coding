package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;

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
}
