package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

  public int maxDepth(TreeNode root) {
    return maxDepthHelper(root);
  }

  private int maxDepthHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    int leftMax = maxDepthHelper(root.left);
    int rightMax = maxDepthHelper(root.right);

    return Math.max(1 + leftMax, 1 + rightMax);
  }

  @Test
  public void test1() {
    HelperTree helperTree1 = new HelperTree();
    TreeNode treeNode = helperTree1.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    System.out.println(maxDepth(treeNode));
  }
}
