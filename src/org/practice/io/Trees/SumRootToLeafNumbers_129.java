package org.practice.io.Trees;

import java.util.List;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class SumRootToLeafNumbers_129 {


  int mainSum = 0;

  public int sumNumbers(TreeNode root) {
    helperSumRootToLeaf("", root);
    return mainSum;
  }


  public void helperSumRootToLeaf(String current, TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      mainSum += Integer.valueOf(current + root.val);
    }

    helperSumRootToLeaf(current + root.val, root.left);
    helperSumRootToLeaf(current + root.val, root.right);
  }

  public void helperSumRootToLeaf(String current, TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      System.out.println(current + root.val);
      int value = getIntegerValue(current + root.val);
      result.add(value);
      System.out.println(value);
    }

    helperSumRootToLeaf(current + root.val, root.left, result);
    helperSumRootToLeaf(current + root.val, root.right, result);
  }

  private Integer getIntegerValue(String current) {
    int value = 0;
    int index = 0;
    for (int i = current.length() - 1; i > -1; i--) {
      Long newValue = (long) (Math.pow(10, index) * Character.getNumericValue(current.charAt(i)));
      value += newValue.intValue();
      index++;
    }
    return value;
  }

  @Test
  public void test() {
    TreeNode treeNode = new HelperTree().generateBinaryTree(new Integer[]{4, 9, 0, 5, 1});
    sumNumbers(treeNode);
  }

}
