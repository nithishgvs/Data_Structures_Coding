package org.leetcode.Trees;

import org.junit.Test;

public class ClosestBinarySearchTreeValue_270 {

  public int closestValue(TreeNode root, double target) {
    return helperMethod(root, target, Math.abs(root.val - target), root.val);
  }

  public int helperMethod(TreeNode root, double target, double absDiff, int value) {

    if (root.left == null && root.right == null) {
      return value;
    }
    int leftValue = Integer.MAX_VALUE;
    int rightValue = Integer.MAX_VALUE;
    if (root.left != null) {
      leftValue = helperMethod(root.left, target,
          Math.abs(root.left.val - target) < absDiff ? Math.abs(root.left.val - target) : absDiff,
          Math.abs(root.left.val - target) < absDiff ? root.left.val : value);
    }

    if (root.right != null) {
      rightValue = helperMethod(root.right, target,
          Math.abs(root.right.val - target) < absDiff ? Math.abs(root.right.val - target) : absDiff,
          Math.abs(root.right.val - target) < absDiff ? root.right.val : value);
    }

    if (leftValue == Integer.MAX_VALUE) {
      return rightValue;
    }

    if (rightValue == Integer.MAX_VALUE) {
      return leftValue;
    }

    if (Math.abs(leftValue - target) < Math.abs(rightValue - target)) {
      return leftValue;
    } else {
      return rightValue;
    }
  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{4, 2, 5, 1, 3, 7, 8, 9});
    System.out.println(closestValue(root, 7.714286));
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{2,1});
    System.out.println(closestValue(root, 2147483647.0));
  }

}
