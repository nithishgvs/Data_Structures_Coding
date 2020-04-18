package org.leetcode.Trees;

import org.junit.Test;

public class DeleteLeavesWithaGivenValue_1325 {

  public TreeNode removeLeafNodes(TreeNode root, int target) {

    if (root == null) {
      return null;
    }
    return removeLeafHelper(root, target);

  }

  private TreeNode removeLeafHelper(TreeNode treeNode, int target) {
    if (treeNode == null) {
      return null;
    }

    treeNode.right = removeLeafHelper(treeNode.right, target);
    treeNode.left = removeLeafHelper(treeNode.left, target);

    if (treeNode.left == null && treeNode.right == null && treeNode.val == target) {
      return null;
    }

    return treeNode;
  }


  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    removeLeafNodes(root, 2);
  }

  @Test
  public void test2() {
    HelperTree helperTree=new HelperTree();
    TreeNode treeNode=helperTree.generateBinaryTree(new Integer[]{1,1,1});
    removeLeafNodes(treeNode, 1);
  }

}
