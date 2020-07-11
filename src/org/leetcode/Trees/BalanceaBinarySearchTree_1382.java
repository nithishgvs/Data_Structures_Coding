package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree_1382 {

  public TreeNode balanceBST(TreeNode root) {

    List<Integer> sortedList = new ArrayList<>();

    inOrder(root, sortedList);

    TreeNode newRoot = null;

    return helperTree(newRoot, sortedList, 0, sortedList.size() - 1);

  }

  private TreeNode helperTree(TreeNode newRoot, List<Integer> list, int low, int high) {
    if (low > high) {
      return null;
    }
    if (low == high) {
      return new TreeNode(list.get(low));
    }
    int mid = ((high - low) / 2) + low;
    if (newRoot == null) {
      newRoot = new TreeNode(list.get(mid));
    }
    newRoot.left = helperTree(newRoot.left, list, low, mid - 1);
    newRoot.right = helperTree(newRoot.right, list, mid + 1, high);

    return newRoot;
  }


  public void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      inOrder(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      inOrder(root.right, list);
    }

  }

}
