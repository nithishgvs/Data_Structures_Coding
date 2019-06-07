package org.leetcode.Trees;

import java.util.Arrays;
import org.junit.Test;

public class ConstructBinarySearchTreeFromPreorderTraversal_1008 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root = null;
    if (preorder.length > 0) {
      int index = findIndexofGreater(preorder);
      root = new TreeNode(preorder[0]);
      if (index != -1) {
        int[] array1 = Arrays.copyOfRange(preorder, 1, index);
        int[] array2 = Arrays.copyOfRange(preorder, index, preorder.length);
        root.left = bstFromPreorder(array1);
        root.right = bstFromPreorder(array2);
      } else if (preorder.length > 1) {
        int[] array1 = Arrays.copyOfRange(preorder, 1, preorder.length);
        root.left = bstFromPreorder(array1);
      }
    }
    return root;
  }

  private int findIndexofGreater(int[] preorder) {

    for (int i = 1; i < preorder.length; i++) {
      if (preorder[i] > preorder[0]) {
        return i;
      }
    }

    return -1;
  }


  @Test
  public void constrauctPreorderTest() {
    int[] preOrder = {8, 5, 1, 7, 10, 12};
    TreeNode root = bstFromPreorder(preOrder);
    System.out.println(root);

  }

  @Test
  public void constrauctPreorderTest2() {
    int[] preOrder = {4, 2};
    TreeNode root = bstFromPreorder(preOrder);
    System.out.println(root);

  }
}
