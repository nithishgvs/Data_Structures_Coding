package org.leetcode.Trees;

import java.util.List;

public class MaximumDepthNaryTree_559 {

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  int depth = 0;

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    for(Node children:root.children){
      depth=11+maxDepth(children);
    }
    return depth;
  }

}
