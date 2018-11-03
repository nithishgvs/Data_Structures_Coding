package org.leetcode.Trees;

import org.junit.Test;

public class MaximumBinaryTree_654 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return maxTreeHelper(nums, 0, nums.length - 1);
  }


  TreeNode maxTreeHelper(int[] nums, int l, int h) {
    if (l > h) {
      return null;
    }
    if (l == h) {
      new TreeNode(nums[l]);
    }
    int maxIndex = maxElementIndex(nums, l, h);
    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = maxTreeHelper(nums, l, maxIndex - 1);
    root.right = maxTreeHelper(nums, maxIndex + 1, h);
    return root;
  }


  public int maxElementIndex(int[] array, int l, int h) {
    int maxIndex = l;

    int maxElement = array[l];

    for (int i = l + 1; i <= h; i++) {
      if (array[i] > maxElement) {
        maxElement = array[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }


  @Test
  public void testTree() {
    int[] array = {3, 2, 1, 6, 0, 5};
    TreeNode root = constructMaximumBinaryTree(array);
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
