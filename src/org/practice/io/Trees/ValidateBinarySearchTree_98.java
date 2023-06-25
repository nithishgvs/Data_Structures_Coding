package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class ValidateBinarySearchTree_98 {


  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helperTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helperTree(TreeNode root, long minValue, long maxValue) {

    if (root == null) {
      return true;
    }

    if (root.val <= minValue || root.val >= maxValue) {
      return false;
    }

    return helperTree(root.left, minValue, root.val) && helperTree(root.right, root.val, maxValue);
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{2, 1, 3});
    treeNode = helperTree.generateBinaryTree(new Integer[]{10, 5, 15, null, null, 6, 20});
    treeNode = helperTree.generateBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6});
    //treeNode = helperTree.generateBinaryTree(new Integer[]{Integer.MAX_VALUE});
    // treeNode = helperTree.generateBinaryTree(new Integer[]{0});
    System.out.println(isValidBST(treeNode));
  }

}
