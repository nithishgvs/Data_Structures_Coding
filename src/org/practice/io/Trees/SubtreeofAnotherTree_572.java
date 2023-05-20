package org.practice.io.Trees;

import org.junit.Test;
import org.leetcode.Trees.HelperTree;
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
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
    TreeNode root2 = helperTree.generateBinaryTree(new Integer[]{4, 1, 2});
    System.out.println(isSubtree(root, root2));
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{3, 4, 5, 1, 2});
    TreeNode root2 = helperTree.generateBinaryTree(new Integer[]{4, 1, 2});
    System.out.println(isSubtree(root, root2));
  }


  @Test
  public void test3() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{4, 1, null, null, 2});
    TreeNode root2 = helperTree.generateBinaryTree(new Integer[]{1, null, 4, 2});
    System.out.println(isSubtree(root, root2));
  }
}
