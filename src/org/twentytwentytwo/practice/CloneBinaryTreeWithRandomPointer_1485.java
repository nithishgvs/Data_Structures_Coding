package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomPointer_1485 {


  public class Node {

    int val;
    Node left;
    Node right;
    Node random;

    Node() {
    }

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node left, Node right, Node random) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.random = random;
    }
  }

  public class NodeCopy {

    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    NodeCopy() {
    }

    NodeCopy(int val) {
      this.val = val;
    }

    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.random = random;
    }
  }


  public NodeCopy copyRandomBinaryTree(Node root) {

    Map<Node, NodeCopy> helperMap = new HashMap<>();

    populateMap(root, helperMap);

    copyTree(root, helperMap);

    return helperMap.get(root);
  }

  private void copyTree(Node root, Map<Node, NodeCopy> helperMap) {
    if (root == null) {
      return;
    }
    helperMap.get(root).left = helperMap.get(root.left);
    helperMap.get(root).right = helperMap.get(root.right);
    helperMap.get(root).random = helperMap.get(root.random);
    copyTree(root.left, helperMap);
    copyTree(root.right, helperMap);
  }

  private void populateMap(Node root, Map<Node, NodeCopy> helperMap) {
    if (root == null) {
      return;
    }
    NodeCopy nodeCopy = new NodeCopy(root.val);
    helperMap.put(root, nodeCopy);
    populateMap(root.left, helperMap);
    populateMap(root.right, helperMap);
  }
}
