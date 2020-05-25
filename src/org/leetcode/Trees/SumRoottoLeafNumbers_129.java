package org.leetcode.Trees;

import org.junit.Test;

public class SumRoottoLeafNumbers_129 {

  int sum = 0;

  public int sumNumbers(TreeNode root) {

    if (root == null) {
      return sum;
    }

    int currentSum = 0;


    sumHelper(root, currentSum);

    return sum;

  }

  private void sumHelper(TreeNode root, int currentSum) {

    currentSum = currentSum * 10 + root.val;

    if (root.left == null && root.right == null) {
      sum += currentSum;
      return;
    }

    if (root.left != null) {
      sumHelper(root.left, currentSum);
    }

    if (root.right != null) {
      sumHelper(root.right, currentSum);
    }

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{0});
    sumNumbers(treeNode);
  }
}
