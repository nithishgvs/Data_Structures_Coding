package org.twentytwentytwo.practice;

import org.junit.Test;
import org.leetcode.Trees.TreeNode;

public class SubtreeofAnotherTree_572 {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null || subRoot == null) {
      return false;
    }
    String rootVal = serializeTree(root);
    String subRootVal = serializeTree(subRoot);
    return rootVal.contains(subRootVal);

  }

  public String serializeTree(TreeNode root) {
    if (root == null) {
      return "#";
    }
    String left = serializeTree(root.left);
    String right = serializeTree(root.right);
    String newString = "R" + root.val + "l" + left + "r" + right;
    return newString;
  }

  @Test
  public void test1() {
    TreeNode treeNode1 = new TreeNode(3);
    treeNode1.left = new TreeNode(4);
    treeNode1.right = new TreeNode(5);
    treeNode1.left.left = new TreeNode(1);
    treeNode1.left.right = new TreeNode(2);
    TreeNode treeNode2 = new TreeNode(4);
    treeNode2.left = new TreeNode(1);
    treeNode2.right = new TreeNode(2);
    System.out.println(isSubtree(treeNode1, treeNode1.left));

  }

  @Test
  public void test2() {
    TreeNode treeNode1 = new TreeNode(12);
    TreeNode treeNode2 = new TreeNode(2);
    System.out.println(isSubtree(treeNode1, treeNode2));

  }

}
