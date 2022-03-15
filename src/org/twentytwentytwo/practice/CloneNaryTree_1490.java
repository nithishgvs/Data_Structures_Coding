package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CloneNaryTree_1490 {


  class Node {

    public int val;
    public List<Node> children;


    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public Node cloneTree(Node root) {

    if (root == null) {
      return null;
    }

    Node copy = new Node(root.val);

    cloneHelper(copy, root);

    return copy;

  }

  private void cloneHelper(Node copy, Node root) {
    if (root == null) {
      return;
    }

    List<Node> children = root.children;

    for (Node child : children) {
      Node newChild = new Node(child.val);
      cloneHelper(newChild, child);
      copy.children.add(newChild);
    }

  }


  @Test
  public void test1() {
    Node root = new Node(1);
    Node root3 = new Node(3);
    Node root5 = new Node(5);
    Node root6 = new Node(6);
    root3.children = Arrays.asList(root5, root6);
    Node root2 = new Node(2);
    Node root4 = new Node(4);
    root.children = Arrays.asList(root3, root2, root4);
    cloneTree(root);

  }
}
