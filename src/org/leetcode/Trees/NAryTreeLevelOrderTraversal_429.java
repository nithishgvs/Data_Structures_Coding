package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal_429 {

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
      val = val;
    }

    public Node(int val, List<Node> children) {
      val = val;
      children = children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {

    List<List<Integer>> output = new ArrayList<>();
    if (root == null) {
      return output;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int currentSize = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < currentSize; i++) {
        Node node = queue.poll();
        list.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
          queue.add(child);
        }
      }
      output.add(list);

    }

    return output;

  }

}
