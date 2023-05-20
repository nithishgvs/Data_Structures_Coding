package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class InvertBinaryTree_226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    if (root.left == null && root.right == null) {
      return root;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
    invertTree(root);
  }


}
