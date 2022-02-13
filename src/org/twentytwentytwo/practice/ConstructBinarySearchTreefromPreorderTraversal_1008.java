package org.twentytwentytwo.practice;

import java.util.Arrays;
import org.junit.Test;

public class ConstructBinarySearchTreefromPreorderTraversal_1008 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    return treeHelper(preorder);
  }

  public TreeNode treeHelper(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    int rootValue = preorder[0];
    int greaterIndex = findGreaterIndex(preorder);
    TreeNode root = new TreeNode(rootValue);
    if (greaterIndex != -1) {
      root.right = treeHelper(Arrays.copyOfRange(preorder, greaterIndex, preorder.length));
      root.left = treeHelper(Arrays.copyOfRange(preorder, 1, greaterIndex));
    } else {
      root.left = treeHelper(Arrays.copyOfRange(preorder, 1, preorder.length));
    }
    return root;
  }


  public int findGreaterIndex(int[] preorder) {
    int index = -1;

    for (int i = 1; i < preorder.length; i++) {
      if (preorder[i] > preorder[0]) {
        return i;
      }
    }
    return index;
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

  @Test
  public void test() {
    int[] preOrder = {8, 5, 1, 7, 10, 12};
    TreeNode root = bstFromPreorder(preOrder);
    inorderTraversal(root);
  }

  @Test
  public void test2() {
    int[] preOrder = {3, 1, 2};
    TreeNode root = bstFromPreorder(preOrder);
    inorderTraversal(root);
  }
}
