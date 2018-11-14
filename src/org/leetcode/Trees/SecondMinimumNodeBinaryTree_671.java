package org.leetcode.Trees;

import org.junit.Test;

public class SecondMinimumNodeBinaryTree_671 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int firstMin = Integer.MAX_VALUE;
  int secondMin = Integer.MAX_VALUE;

  public int findSecondMinimumValue(TreeNode root) {

    secondMinimumHelper(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
    if (secondMin == Integer.MAX_VALUE) {
      secondMin = -1;
    }
    return secondMin;

  }

  private void secondMinimumHelper(TreeNode root, int fMin, int sMin) {
    if (root == null) {
      return;
    }
    if (root.val < firstMin) {
      secondMin = firstMin;
      firstMin = root.val;
    }
    if (root.val < secondMin && root.val > firstMin) {
      secondMin = root.val;
    }
    secondMinimumHelper(root.left, fMin, sMin);
    secondMinimumHelper(root.right, fMin, sMin);

  }

  @Test
  public void treeTest1() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    System.out.println(findSecondMinimumValue(root));
  }

  @Test
  public void treeTest2() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    System.out.println(findSecondMinimumValue(root));
  }
}
