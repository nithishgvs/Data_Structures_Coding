package org.leetcode.LinkedList;

import org.junit.Test;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {

  class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  Node head = null;
  Node tail = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    helper(root);
    tail.right = head;
    head.left = tail;
    return head;
  }

  private void helper(Node root) {
    if (root == null) {
      return;
    }

    helper(root.left);
    if (head == null) {
      head = root;
    } else {
      tail.right = root;
      root.left = tail;
    }
    tail = root;
    helper(root.right);
  }


  @Test
  public void test() {
    Node node = new Node(2);
    //node.left = new Node(1);
    //node.right = new Node(3);
    treeToDoublyList(node);
  }

  @Test
  public void test1() {
    Node node = new Node(4);
    node.left = new Node(2);
    node.left.left = new Node(1);
    node.left.right = new Node(3);
    node.right = new Node(5);
    treeToDoublyList(node);
  }
}
