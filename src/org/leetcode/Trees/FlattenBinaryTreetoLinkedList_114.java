package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FlattenBinaryTreetoLinkedList_114 {

  List<TreeNode> list = new ArrayList<>();


  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    preOrder(root);
    for (int i = 1; i < list.size(); i++) {
      root.right = list.get(i);
      root.left = null;
      root = root.right;
    }
    System.out.println(root);
  }


  public void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    list.add(root);
    preOrder(root.left);
    preOrder(root.right);

  }


  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    flatten(root);
  }


}
