package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class NaryTreePreorderTraversal_589 {

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }


  public List<Integer> preorder(Node root) {

    List<Integer> preList = new ArrayList<>();

    helper(root, preList);
    return preList;

  }

  private void helper(Node root, List<Integer> preList) {
    if (root == null) {
      return;
    }
    preList.add(root.val);

    if (root.children != null) {
      for (Node child : root.children) {
        helper(child, preList);
      }
    }
  }


  @Test
  public void test1() {
    Node root = new Node(1);
    Node c1 = new Node(3);
    Node c5 = new Node(5);
    Node c6 = new Node(6);
    c1.children = Arrays.asList(c5, c6);
    Node c2 = new Node(2);
    Node c3 = new Node(4);
    root.children = Arrays.asList(c1, c2, c3);
    preorder(root).forEach(c -> System.out.println(c));

  }

}
