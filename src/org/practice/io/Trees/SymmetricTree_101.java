package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class SymmetricTree_101 {


  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return symmetricHelper(root.left, root.right);
  }

  private boolean symmetricHelper(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if(left!=null && right!=null && left.val==right.val){
      return symmetricHelper(left.right, right.left) && symmetricHelper(left.left, right.right);
    }
    return false;
  }

  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
    System.out.println(isSymmetric(treeNode));

  }

}
