package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees_1305 {

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

    if (root1 == null && root2 == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    inOrder(root1, result);
    inOrder(root2, result);
    Collections.sort(result);
    return result;
  }


  private void inOrder(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    inOrder(node.left, list);
    list.add(node.val);
    inOrder(node.right, list);
  }

}
