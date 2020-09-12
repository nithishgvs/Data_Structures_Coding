package org.leetcode.Trees;

import org.junit.Test;

public class BinaryTreeMaximumPathSum_124 {

  int maxValue = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    int tempMax = treeHelper(root);
    return Math.max(tempMax, maxValue);
  }

  private int treeHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftMax = Math.max(0, treeHelper(root.left));
    int rightMax = Math.max(0, treeHelper(root.right));

    maxValue = Math.max(maxValue, root.val + rightMax + leftMax);

    return root.val + Math.max(leftMax, rightMax);

  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode rootNode = helperTree.generateBinaryTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
    rootNode = helperTree
        .generateBinaryTree(new Integer[]{2, -1, -2});
    inOrderRecursive(rootNode);
    System.out.println(maxPathSum(rootNode));
  }

  public void inOrderRecursive(TreeNode rootNode) {
    if (rootNode == null) {
      return;
    }
    inOrderRecursive(rootNode.left);
    System.out.print(rootNode.val + ", ");
    inOrderRecursive(rootNode.right);
  }

}
