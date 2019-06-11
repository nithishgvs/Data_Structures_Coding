package org.leetcode.Trees;

import org.junit.Test;

public class ConstructBinaryTreePrePostTraversals_889 {


  int preIndex = 0;

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return constructTreeHelper(pre, post, 0, pre.length - 1, post.length);
  }


  public TreeNode constructTreeHelper(int[] pre, int[] post, int l, int h, int size) {
    if (preIndex >= size || l > h) {
      return null;
    }

    TreeNode root = new TreeNode(pre[preIndex]);
    preIndex++;

    //Single element condition && preIndex becomes greater than size of array
    if (l == h || preIndex >= size) {
      return root;
    }

    int i = 0;
    for (i = l; i <= h; i++) {
      if (post[i] == pre[preIndex]) {
        break;
      }
    }

    if (i <= h) {
      root.left = constructTreeHelper(pre, post, l, i, size);
      root.right = constructTreeHelper(pre, post, i + 1, h, size);
    }
    return root;
  }


  @Test
  public void testConstructTree2() {
    int[] preOrder = {52, 33, 25, 12, 27, 39, 34, 48, 65, 60, 78, 72, 90};
    int[] postOrder = {12, 27, 25, 34, 48, 39, 33, 60, 72, 90, 78, 65, 52};
    int[] inOrder = {12, 25, 27, 33, 34, 39, 48, 52, 60, 65, 72, 78, 90};
    TreeNode root = constructFromPrePost(preOrder, postOrder);
    inOrderRecursive(root);
  }

  @Test
  public void testConstructTree1() {
    int[] pre = {1, 2, 4, 5, 3, 6, 7};
    int[] post = {4, 5, 2, 6, 7, 3, 1};
    TreeNode root = constructFromPrePost(pre, post);
    inOrderRecursive(root);
  }


  @Test
  public void testConstructTree3() {
    int[] pre = {2, 1};
    int[] post = {1, 2};
    TreeNode root = constructFromPrePost(pre, post);
    inOrderRecursive(root);
  }

  @Test
  public void testConstructTree4() {
    int[] pre = {2, 1, 3};
    int[] post = {3, 1, 2};
    TreeNode root = constructFromPrePost(pre, post);
    inOrderRecursive(root);
  }

  @Test
  public void testConstructTree5() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{2, 1, null, 3});
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
