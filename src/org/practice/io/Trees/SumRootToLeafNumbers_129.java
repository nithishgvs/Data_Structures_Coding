package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class SumRootToLeafNumbers_129 {

  int sum = 0;

  public int sumNumbers(TreeNode root) {
    helperSumNumbers(root, "");
    return sum;
  }

  private void helperSumNumbers(TreeNode root, String currentSum) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      sum += Integer.valueOf(currentSum + root.val);
      return;
    }

    helperSumNumbers(root.left, currentSum + root.val);
    helperSumNumbers(root.right, currentSum + root.val);
  }


  @Test
  public void test() {
    TreeNode treeNode = new HelperTree().generateBinaryTree(new Integer[]{4, 9, 0, 5, 1});
    System.out.println(sumNumbers(treeNode));
  }
}
