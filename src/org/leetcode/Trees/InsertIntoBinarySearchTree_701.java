package org.leetcode.Trees;

import org.junit.Test;

public class InsertIntoBinarySearchTree_701 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root.val > val) {
      if (root.left != null) {
        insertIntoBST(root.left, val);
      } else {
        root.left = new TreeNode(val);
      }
    } else if (root.val < val) {
      if (root.right == null) {
        root.right = new TreeNode(val);
      } else {
        insertIntoBST(root.right, val);
      }
    }
    return root;
  }

  @Test
  public void testInsertBST() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    System.out.println(insertIntoBST(root, 4)
        .val);
  }
}
