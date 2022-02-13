package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class PathSumII_113 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    pathSumHelper(root, targetSum, new ArrayList<>());
    return result;
  }

  private void pathSumHelper(TreeNode root, int targetSum, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    if (targetSum - root.val == 0 && root.left == null && root.right == null) {
      path.add(root.val);
      result.add(path);
    }
    ArrayList<Integer> newPath = new ArrayList<>();
    newPath.addAll(path);
    newPath.add(root.val);
    pathSumHelper(root.left, targetSum - root.val, newPath);
    ArrayList<Integer> newPath2 = new ArrayList<>();
    newPath2.addAll(path);
    newPath2.add(root.val);
    pathSumHelper(root.right, targetSum - root.val, newPath2);
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
    HelperTree helperTree=new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{0,1,1});
    pathSum(root, 1);
  }
}
