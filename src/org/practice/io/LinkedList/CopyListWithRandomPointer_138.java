package org.practice.io.LinkedList;

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

    Map<Node, Node> nodeMap = new HashMap<>();

    Node current = head;

    while (current != null) {
      nodeMap.put(current, new Node(current.val));
      current = current.next;
    }

    current = head;

    while (current != null) {
      nodeMap.get(current).random = nodeMap.get(current.random);
      nodeMap.get(current).next = nodeMap.get(current.next);
      current = current.next;
    }

    return nodeMap.get(head);

  }

  @Test
  public void test() {
    Node node1 = new Node(3);
    Node node2 = new Node(3);
    Node node3 = new Node(3);
    node1.next = node2;
    node2.next = node3;
    node2.random = node1;

    copyRandomList(node1);
  }


  @Test
  public void test2() {
    Node node1 = new Node(7);
    Node node2 = new Node(13);
    Node node3 = new Node(11);
    Node node4 = new Node(10);
    Node node5 = new Node(1);
    node1.next = node2;
    node2.next = node3;
    node2.random = node1;
    node3.next = node4;
    node3.random = node5;
    node4.next = node5;
    node4.random = node3;
    node5.random = node1;

    copyRandomList(node1);
  }

}
