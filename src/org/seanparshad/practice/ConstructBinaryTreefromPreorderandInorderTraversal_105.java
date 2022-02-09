package org.seanparshad.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left,
        TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int n = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return treeHelper(inorderMap, preorder, 0, inorder.length - 1);

  }

  private TreeNode treeHelper(Map<Integer, Integer> inorderMap, int[] preorder, int start,
      int end) {

    if (start > end) {
      return null;
    }

    int rootValue = preorder[n];
    n++;

    int rootIndex = inorderMap.get(rootValue);
    TreeNode root = new TreeNode(rootValue);
    root.left = treeHelper(inorderMap, preorder, start, rootIndex - 1);
    root.right = treeHelper(inorderMap, preorder, rootIndex + 1, end);
    return root;

  }

  @Test
  public void test1() {
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {3, 9, 20, 15, 7};
    TreeNode root = buildTree(inorder, postorder);
    inorderTraversal(root);
  }

  public void inorderTraversal(
      TreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left);
    System.out.print(root.val + "->");
    inorderTraversal(root.right);
  }
}
