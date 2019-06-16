package org.leetcode.LinkedList;

import org.junit.Test;

public class FlattenaMultilevelDoublyLinkedList_430 {

  class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  }

  public Node flatten(Node head) {
    Node first1 = head, first2, second1, second2;
    while (first1 != null) {
      if (first1.child == null) {
        first1 = first1.next;
      } else {
        first2 = first1.next;
        second1 = first1.child;
        second2 = second1;
        while (second2.next != null) {
          second2 = second2.next;
        }
        first1.child = null;
        first1.next = second1;
        second1.prev = first1;
        if (first2 != null) {
          first2.prev = second2;
        }
        second2.next = first2;
        first1 = first1.next;
      }
    }
    return head;
  }

  public Node flatten1(Node head) {
    Node current = head;

    while (current != null) {
      if (current.child == null) {
        current = current.next;
      } else {
        Node tempCurrent = current.next;
        Node childNodeHead = flatten1(current.child);
        current.next = childNodeHead;
        childNodeHead.prev = current;
        current.child = null;
        while (current.next != null) {
          if (current.next.next != null) {
            current = current.next.next;
          }
        }
        tempCurrent.prev = current;
        current.next = flatten1(tempCurrent);
      }
    }

    return head;
  }


  @Test
  public void test1() {
    Node head = new Node(1, null, null, null);
    head.next = new Node(2, head, null, null);
    head.next.next = new Node(3, head.next, null, null);
    Node child1 = new Node(7, null, null, null);
    child1.next = new Node(8, child1, null, null);
    Node child2 = new Node(11, null, null, null);
    child2.next = new Node(12, child2, null, null);
    child1.next.child = child2;
    child1.next.next = new Node(9, child1.next, null, null);
    child1.next.next.next = new Node(10, child1.next.next, null, null);
    head.next.next.child = child1;
    head.next.next.next = new Node(4, head.next.next, null, null);
    head.next.next.next.next = new Node(5, head.next.next.next, null, null);
    head.next.next.next.next.next = new Node(6, head.next.next.next.next, null, null);
    Node x = flatten1(head);
    while (x != null) {
      System.out.print("current: " + x.val);
      if (x.prev != null) {
        System.out.print(" prev:" + x.prev.val);
      }
      if (x.next != null) {
        System.out.print(" next:" + x.next.val);
      }
      System.out.println();
      x = x.next;
    }
  }

}
