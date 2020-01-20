package org.leetcode.Trees;

import org.junit.Test;

public class MinimumDepthofBinaryTree_111 {

  public int minDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }
    return minDepthHelper(root);

  }

  private int minDepthHelper(TreeNode root) {
    if(root==null){
      return Integer.MAX_VALUE;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    return 1 + Math.min(minDepth(root.left), minDepth(root.right));

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    System.out.println(
        minDepth(helperTree.generateBinaryTree(new Integer[]{1,2})));
  }


}
