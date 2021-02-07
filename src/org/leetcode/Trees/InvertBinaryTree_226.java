package org.leetcode.Trees;

import org.junit.Test;

public class InvertBinaryTree_226 {


  public TreeNode invertTree(TreeNode root) {
    helper(root);
    return root;
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    helper(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
    invertTree(treeNode);
  }

}
