package org.twentytwentytwo.practice;

import org.junit.Test;

public class FlattenaMultilevelDoublyLinkedList_430 {

  class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }


  public Node flatten(Node head) {
    if (head == null) {
      return head;
    }

    Node curr = head;

    while (curr != null) {
      Node nextNode = curr.next;

      if (curr.child != null) {
        curr.child.prev = curr;
        Node flattenedListHead = flatten(curr.child);
        curr.next = flattenedListHead;
        curr.child = null;

        if (nextNode != null) {
          Node lastNodeInFlattenedList = getLastNodeInList(flattenedListHead);
          nextNode.prev = lastNodeInFlattenedList;
          lastNodeInFlattenedList.next = nextNode;
        }
      }

      curr = nextNode;
    }

    return head;
  }

  private Node getLastNodeInList(Node node) {
    if (node == null) {
      return null;
    }

    Node curr = node;
    while (curr.next != null) {
      curr = curr.next;
    }

    return curr;
  }


  @Test
  public void test1() {
    Node n1 = new Node();
    n1.val = 1;
    Node n2 = new Node();
    n2.val = 2;
    n2.prev = n1;
    n1.next = n2;
    Node n3 = new Node();
    n3.val = 3;
    n3.prev = n2;
    n2.next = n3;

    Node n7 = new Node();
    n7.val = 7;

    Node n8 = new Node();
    n8.val = 8;
    n8.prev = n7;
    n7.next = n8;

    n3.child = n7;

    flatten(n1);

  }
}
