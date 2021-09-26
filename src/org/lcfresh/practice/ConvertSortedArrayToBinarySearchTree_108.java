package org.lcfresh.practice;

import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTree_108 {

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


  public TreeNode sortedArrayToBST(int[] nums) {
    return helperTree(nums, 0, nums.length - 1);
  }


  public TreeNode helperTree(int[] nums, int start, int end) {
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    if (start > end) {
      return null;
    }
    int mid = (end - start) / 2 + start;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helperTree(nums, start, mid - 1);
    root.right = helperTree(nums, mid + 1, end);
    return root;
  }

  @Test
  public void test1() {
    int[] nums = {-10, -3, 0, 5};
    TreeNode node = sortedArrayToBST(nums);
    System.out.println(node);
  }

}
