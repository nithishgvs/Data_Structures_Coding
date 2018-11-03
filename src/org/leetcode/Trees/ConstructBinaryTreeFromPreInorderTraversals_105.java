package org.leetcode.Trees;

import org.junit.Test;

public class ConstructBinaryTreeFromPreInorderTraversals_105 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    return binaryTreeHelper(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
  }

  private TreeNode binaryTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd,
      int preStart, int preEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    if (inStart == inEnd) {
      return new TreeNode(inorder[inEnd]);
    }
    int index = findIndex(inorder, preorder[preStart]);

    TreeNode root = new TreeNode(preorder[preStart]);

    root.left = binaryTreeHelper(preorder, inorder, inStart, index - 1, preStart + 1,
        preStart + index - inStart);
    root.right = binaryTreeHelper(preorder, inorder, index + 1, inEnd,
        index + preStart - inStart + 1, preEnd);
    return root;
  }


  public int findIndex(int[] inorder, int element) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == element) {
        return i;
      }
    }
    return -1;
  }

  @Test

  public void testConstructTree() {

    int[] inorder = {9, 3, 15, 20, 7};
    int[] preOrder = {3, 9, 20, 15, 7};
    TreeNode root = buildTree(preOrder, inorder);
    inOrderRecursive(root);

  }

  @Test
  public void testConstructTree2() {
    int[] preorder = {52, 33, 25, 12, 27, 39, 34, 48, 65, 60, 78, 72, 90};
    int[] inorder = {12, 25, 27, 33, 34, 39, 48, 52, 60, 65, 72, 78, 90};
    TreeNode root = buildTree(preorder, inorder);
    inOrderRecursive(root);
  }

  public void inOrderRecursive(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrderRecursive(root.left);
    System.out.print(root.val + " ");
    inOrderRecursive(root.right);

  }

}
