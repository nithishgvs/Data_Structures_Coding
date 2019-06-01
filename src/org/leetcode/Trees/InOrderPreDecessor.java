package org.leetcode.Trees;

import org.junit.Test;

public class InOrderPreDecessor {

  public class BinarySearchTreeNode {

    int val;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    BinarySearchTreeNode(int x) {
      val = x;
    }
  }


  public BinarySearchTreeNode inOrderPreDecessor(BinarySearchTreeNode root, int targetNode) {

    if (root == null) {
      return null;
    }

    BinarySearchTreeNode current = root;
    BinarySearchTreeNode prevNode = null;

    while (current != null) {
      if (current.val > targetNode) {
        current = current.left;
      } else if (current.val < targetNode) {
        prevNode = current;
        current = current.right;
      } else {
        if (current.left != null) {
          prevNode = current;
        }
        current = current.left;
        while (current != null) {
          prevNode = current;
          current = current.left;
        }
      }
    }

    return prevNode;
  }


  private void inorderTraversal(BinarySearchTreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left);
    System.out.print(root.val + " ");
    inorderTraversal(root.right);
  }

  private BinarySearchTreeNode populateBinarySearchTree() {
    BinarySearchTreeNode rootNode = new BinarySearchTreeNode(50);
    rootNode.left = new BinarySearchTreeNode(30);
    rootNode.left.left = new BinarySearchTreeNode(20);
    rootNode.left.right = new BinarySearchTreeNode(40);
    rootNode.right = new BinarySearchTreeNode(70);
    rootNode.right.left = new BinarySearchTreeNode(60);
    rootNode.right.right = new BinarySearchTreeNode(80);
    return rootNode;
  }


  private BinarySearchTreeNode populateBinarySearchTree2() {
    BinarySearchTreeNode rootNode = new BinarySearchTreeNode(20);
    rootNode.left = new BinarySearchTreeNode(15);
    rootNode.left.left = new BinarySearchTreeNode(10);
    rootNode.left.left.left = new BinarySearchTreeNode(5);
    rootNode.left.right = new BinarySearchTreeNode(18);
    rootNode.left.right.left = new BinarySearchTreeNode(17);
    rootNode.left.right.right = new BinarySearchTreeNode(20);
    rootNode.right = new BinarySearchTreeNode(40);
    rootNode.right.left = new BinarySearchTreeNode(35);
    rootNode.right.right = new BinarySearchTreeNode(45);
    rootNode.right.right.left = new BinarySearchTreeNode(44);
    rootNode.right.right.right = new BinarySearchTreeNode(49);
    return rootNode;
  }

  @Test
  public void testInorderPredecessor() {
    BinarySearchTreeNode rootNode = populateBinarySearchTree();
    inorderTraversal(rootNode);
    BinarySearchTreeNode resultNode = inOrderPreDecessor(rootNode, 17);
    System.out.println(resultNode.val);
  }

}
