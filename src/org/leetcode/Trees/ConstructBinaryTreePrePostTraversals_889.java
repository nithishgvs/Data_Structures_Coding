package org.leetcode.Trees;

import org.junit.Test;

public class ConstructBinaryTreePrePostTraversals_889 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return binaryTreeHelper(pre, post, 0, pre.length - 1, 0, post.length - 1);
  }

  private TreeNode binaryTreeHelper(int[] pre, int[] post, int preStart, int preEnd, int postStart,
      int postEnd) {

    if (pre.length == 0 || post.length == 0) {
      return null;
    }

    if (preStart > preEnd || postStart > postEnd) {
      return null;
    }

    TreeNode root = new TreeNode(post[preStart]);

    int element = post[preStart+1];
    int index = -1;

    for (int i = 0; i < post.length; i++) {
      if (post[i] == element) {
        index = i;
        break;
      }
    }

    root.left = binaryTreeHelper(pre, post, preStart + 1, preStart + index, postStart,
        postStart + index - 2);


    return root;
  }


  @Test
  public void testConstructTree2() {
    int[] preOrder = {52, 33, 25, 12, 27, 39, 34, 48, 65, 60, 78, 72, 90};
    int[] postOrder = {12, 27, 25, 34, 48, 39, 33, 60, 72, 90, 78, 65, 52};
    TreeNode root = constructFromPrePost(preOrder, postOrder);
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
