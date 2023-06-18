package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class LowestCommonAncestorOfABinaryTree_236 {


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
      return root;
    }

    return lcaHelper(root, p, q);

  }

  private TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
      return root;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lcaHelper(root.left, p, q);
    TreeNode right = lcaHelper(root.right, p, q);

    if (left == null && right != null) {
      return right;
    } else if (right == null && left != null) {
      return left;
    } else if (left != null && right != null) {
      return root;
    }

    return null;
  }

  @Test
  public void test1() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    TreeNode test = lcaHelper(treeNode, treeNode.left, treeNode.right);
    System.out.println(test);
  }
}
