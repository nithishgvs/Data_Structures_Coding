package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PathSumII_113 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  List<List<Integer>> output = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return output;
    }
    List<Integer> integerList = new ArrayList<>();
    integerList.add(root.val);
    if (sum == root.val && root.left == null && root.right == null) {
      output.add(integerList);
      return output;
    }
    pathSumHelper(root.left, sum, root.val, integerList);
    pathSumHelper(root.right, sum, root.val, integerList);
    return output;
  }

  private void pathSumHelper(TreeNode root, int targetSum, int currentSum,
      List<Integer> integerList) {
    if (root == null) {
      return;
    }
    if (root.val + currentSum == targetSum && root.left == null && root.right == null) {
      List<Integer> list = new ArrayList<>(integerList);
      list.add(root.val);
      output.add(list);
      return;
    }
    List<Integer> list = new ArrayList<>(integerList);
    list.add(root.val);
    pathSumHelper(root.left, targetSum, currentSum + root.val, list);
    pathSumHelper(root.right, targetSum, currentSum + root.val, list);
  }


  @Test
  public void testPathSum() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    pathSum(root, 22);
  }

  @Test
  public void testPathSum1() {
    TreeNode root = new TreeNode(1);
    pathSum(root, 1);
  }


  @Test
  public void testPathSum2() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    pathSum(root, 1);
  }


  @Test
  public void testPathSum3() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(-2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.left.left.left = new TreeNode(-1);
    root.right = new TreeNode(-3);
    root.right.left = new TreeNode(-2);
    pathSum(root, -1);
  }
}
