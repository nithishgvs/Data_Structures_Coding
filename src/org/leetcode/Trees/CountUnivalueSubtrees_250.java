package org.leetcode.Trees;

import org.junit.Test;

public class CountUnivalueSubtrees_250 {

  int result = 0;

  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helperTree(root);
    return result;
  }

  private int helperTree(TreeNode root) {
    int left = root.left == null ? root.val : helperTree(root.left);
    int right = root.right == null ? root.val : helperTree(root.right);
    if (left == root.val && right == root.val) {
      result++;
      return root.val;
    }
    return Integer.MAX_VALUE;
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{5, 1, 5, 5, 5, null, 5});
    System.out.println(countUnivalSubtrees(root));
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{5, 5, 5, 5, 5, null, 5});
    System.out.println(countUnivalSubtrees(root));
  }

  @Test
  public void test3() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{1,1,1,5,5,null,5});
    System.out.println(countUnivalSubtrees(root));
  }
}
