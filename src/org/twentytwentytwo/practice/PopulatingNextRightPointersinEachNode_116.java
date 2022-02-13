package org.twentytwentytwo.practice;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class PopulatingNextRightPointersinEachNode_116 {

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node root) {

    if (root == null) {
      return root;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Node prev = null;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node polled = queue.poll();
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
        if (prev != null) {
          prev.next = polled;
        }
        prev = polled;
      }
      prev = null;
    }

    return root;

  }

  @Test
  public void testNextRight() {
    Node root = new Node(1, null, null, null);
    root.left = new Node(2, null, null, null);
    root.right = new Node(3, null, null, null);
    root.left.left = new Node(4, null, null, null);
    root.left.right = new Node(5, null, null, null);
    root.right.left = new Node(6, null, null, null);
    root.right.right = new Node(7, null, null, null);
    connect(null);
  }
}
