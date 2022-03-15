package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph_133 {

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {

    if (node == null) {
      return null;
    }

    Node[] visited = new Node[200];

    Node copy = new Node();
    copy.val = node.val;

    cloneHelper(node, copy, visited);

    return copy;
  }

  private void cloneHelper(Node node, Node copy, Node[] visited) {
    visited[copy.val] = copy;
    for (Node neigh : node.neighbors) {
      if (visited[neigh.val] == null) {
        Node newNode = new Node();
        newNode.val = neigh.val;
        copy.neighbors.add(newNode);
        cloneHelper(neigh, newNode, visited);
      } else {
        copy.neighbors.add(visited[neigh.val]);
      }
    }
  }
}
