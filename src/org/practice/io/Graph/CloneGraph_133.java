package org.practice.io.Graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph_133 {

  private Node e;

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

    Node[] visited = new Node[101];

    Node copy = new Node();
    copy.val = node.val;

    cloneGraphHelper(copy, node, visited);

    return copy;
  }

  private void cloneGraphHelper(Node copy, Node node, Node[] visited) {
    visited[copy.val] = copy;
    for (Node neighbour : node.neighbors) {
      if (visited[neighbour.val] == null) {
        Node newNode = new Node();
        newNode.val = neighbour.val;
        copy.neighbors.add(newNode);
        cloneGraphHelper(newNode, neighbour, visited);
      } else {
        copy.neighbors.add(visited[neighbour.val]);
      }
    }
  }

}
