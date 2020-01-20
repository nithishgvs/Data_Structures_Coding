package org.leetcode.Trees;

import org.junit.Test;

public class BalancedBinaryTree_110 {

  public boolean isBalanced(TreeNode root) {

    if (root == null) {
      return true;
    }

    int leftHeight = heightTree(root.left);
    int rightHeight = heightTree(root.right);
    if (Math.abs(leftHeight - rightHeight) <= 1) {
      return isBalanced(root.left) && isBalanced(root.right);
    } else {
      return false;
    }

  }

  private int heightTree(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    if (treeNode.left == null && treeNode.right == null) {
      return 1;
    }
    return 1 + Math.max(heightTree(treeNode.left), heightTree(treeNode.right));

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    System.out.println(
        isBalanced(helperTree.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    System.out.println(
        isBalanced(helperTree.generateBinaryTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
  }
}
