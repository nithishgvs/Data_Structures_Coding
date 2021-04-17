package org.leetcode.Trees;

import org.junit.Test;

public class SumofNodeswithEvenValuedGrandparent_1315 {


  int sum = 0;

  public int sumEvenGrandparent(TreeNode root) {
    if (root == null) {
      return sum;
    }
    int[] details = {-1, -1};
    helperTree(root, details);
    return sum;
  }

  private void helperTree(TreeNode root, int[] details) {
    if (root == null) {
      return;
    }
    if (details[1] % 2 == 0) {
      sum += root.val;
    }

    helperTree(root.left, new int[]{root.val, details[0]});
    helperTree(root.right, new int[]{root.val, details[0]});
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree
        .generateBinaryTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
    System.out.println(sumEvenGrandparent(treeNode));
  }
}
