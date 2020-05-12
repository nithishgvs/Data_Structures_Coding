package org.leetcode.Trees;

import org.junit.Test;

public class TrimABinarySearchTree_669 {


  public TreeNode trimBST(TreeNode root, int L, int R) {

    if (root == null) {
      return null;
    }

    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);

    if (root.val < L) {
      root = root.right;
    } else if (root.val > R) {
      root = root.left;
    }

    return root;

  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{3, 1, 4, null, 2});
    //inorder(root);
    TreeNode root1 = trimBST(root, 1, 2);
    inorder(root);

  }


}
