package org.twentytwentytwo.practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII_117 {

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

    public Node(int _val, Node _left,
        Node _right,
        Node _next) {
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


}
