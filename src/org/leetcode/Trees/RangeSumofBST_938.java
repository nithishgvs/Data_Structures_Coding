package org.leetcode.Trees;

import org.junit.Test;

public class RangeSumofBST_938 {

  int sum = 0;

  public int rangeSumBST(TreeNode root, int L, int R) {
    helper(root, L, R);
    return sum;
  }

  private void helper(TreeNode root, int l, int r) {
    if (root == null) {
      return;
    }
    if (root.val >= l && root.val <= r) {
      sum += root.val;
    }
    if(!(root.val<=l)) {
      helper(root.left, l, r);
    }
    if(!(root.val>=r)) {
      helper(root.right, l, r);
    }

  }


  @Test
  public void test(){
    HelperTree helperTree=new HelperTree();
    TreeNode root=helperTree.generateBinaryTree(new Integer[]{10,5,15,3,7,13,18,1,null,6});

    System.out.println(rangeSumBST(root,6,10));
  }
}
