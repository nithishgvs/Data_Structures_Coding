package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class IncreasingOrderSearchTree_897 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  List<Integer> inorderList = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {
    inOrder(root);
    root = new TreeNode(inorderList.get(0));
    for (int i = 1; i < inorderList.size(); i++) {
      insertionRecursive(root, inorderList.get(i));
    }
    return root;
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    inorderList.add(root.val);
    inOrder(root.right);

  }

  public TreeNode insertionRecursive(TreeNode root, int data) {

    if (root == null) {
      root = new TreeNode(data);
      return root;
    }

    if (root.val > data) {
      root.left = insertionRecursive(root.left, data);
    } else if (root.val < data) {
      root.right = insertionRecursive(root.right, data);
    }

    return root;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(5);
    // Left tree in Pic
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    // root.left.left = null;
    // Right tree in Pic
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    increasingBST(root);
    System.out.println(Integer.MAX_VALUE);
  }

}
