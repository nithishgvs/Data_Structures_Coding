package org.leetcode.LinkedList;

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

    Node cloneHead = null;

    return cloneHead;

  }

  //[[7,null],[13,0],[11,4],[10,2],[1,0]]

  @Test
  public void test() {
    Node head = new Node(7);
    head.next = new Node(13);
    head.next.random = new Node(0);
    head.next.next = new Node(11);
    head.next.next.random = new Node(4);
    head.next.next.next = new Node(10);
    head.next.next.next.random = new Node(2);
    head.next.next.next.next = new Node(1);
    head.next.next.next.next.random = new Node(0);

    copyRandomList(head);

  }

}
