package org.twentytwentytwo.practice;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class SumRoottoLeafNumbers_129 {

  int mainSum = 0;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper(root, "");
    return mainSum;

  }


  private void helper(TreeNode root, String sum) {
    if (root == null) {
      return;
    }
    String newSum = sum + root.val;

    if (root.left == null && root.right == null) {
      mainSum += Integer.valueOf(newSum);
    }
    helper(root.left, newSum);
    helper(root.right, newSum);
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{4, 9, 0, 5, 1});
    System.out.println(sumNumbers(root));
  }

}
