package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class PathSum_112 {


  public boolean hasPathSum(TreeNode root, int targetSum) {

    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null && root.val - targetSum == 0) {
      return true;
    }

    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);

  }


  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
    System.out.println(hasPathSum(treeNode, 22));
  }

  @Test
  public void test2() {
    TreeNode root = new TreeNode(5);
    // Left tree in Pic
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    // Right tree in Pic
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    System.out.println(hasPathSum(root, 212));
  }


}
