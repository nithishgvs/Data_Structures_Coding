package org.leetcode.Trees;

import org.junit.Test;

public class BinaryTreePruning_814 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode pruneTree(TreeNode root) {

    if (root != null && root.val == 0) {
      if (root.left == null && root.right == null) {
        root = null;
      }
    }
    if (root != null) {
      root.left = pruneTree(root.left);
      root.right = pruneTree(root.right);
    }

    if (root != null && root.val == 0 && root.left == null && root.right == null) {
      root = null;
    }
    return root;
  }


  @Test
  public void testPrune1() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(0);
    treeNode.right.left = new TreeNode(0);
    treeNode.right.right = new TreeNode(1);
    pruneTree(treeNode);
  }

  @Test
  public void testPrune2() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(0);
    treeNode.left.left = new TreeNode(0);
    treeNode.left.right = new TreeNode(0);
    treeNode.right = new TreeNode(1);
    treeNode.right.left = new TreeNode(0);
    treeNode.right.right = new TreeNode(1);
    pruneTree(treeNode);
  }


}
