package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class SameTree_100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null && q == null) {
      return true;
    }
    if (p == null & q != null) {
      return false;
    }

    if (p != null & q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

  }

  @Test
  public void test1() {
    HelperTree helperTree1 = new HelperTree();
    TreeNode treeNode = helperTree1.generateBinaryTree(new Integer[]{1, 2, 1});
    TreeNode treeNode2 = helperTree1.generateBinaryTree(new Integer[]{1, 1, 2});
    isSameTree(treeNode, treeNode2);
  }


}
