package org.leetcode.Trees;

import java.util.LinkedList;
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

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }


  private int height(Node root) {
    if (root == null) {
      return 0;
    }

    int lHeight = height(root.left) + 1;
    int rHeight = height(root.right) + 1;

    return Math.max(lHeight, rHeight);
  }


  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();

    queue1.add(root);

    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      while (!queue1.isEmpty()) {
        Node popped = ((LinkedList<Node>) queue1).pop();
        popped.next = queue1.peek();
        if (popped.left != null) {
          ((LinkedList<Node>) queue2).add(popped.left);
        }
        if (popped.right != null) {
          ((LinkedList<Node>) queue2).add(popped.right);
        }
      }

      while (!queue2.isEmpty()) {
        Node popped = ((LinkedList<Node>) queue2).pop();
        popped.next = queue2.peek();
        if (popped.left != null) {
          ((LinkedList<Node>) queue1).add(popped.left);
        }
        if (popped.right != null) {
          ((LinkedList<Node>) queue1).add(popped.right);
        }
      }
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
    connect(root);
  }

}
