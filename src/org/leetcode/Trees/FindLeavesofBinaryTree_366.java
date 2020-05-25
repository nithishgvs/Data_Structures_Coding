package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FindLeavesofBinaryTree_366 {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> output = new ArrayList<>();

    while (root != null) {
      List<Integer> list = new ArrayList<>();
      root = helper(root, list);
      output.add(list);
    }

    return output;
  }

  private TreeNode helper(TreeNode root, List<Integer> list) {

    if (root.right == null && root.left == null) {
      list.add(root.val);
      return null;
    }
    if (root.left != null) {
      root.left = helper(root.left, list);
    }
    if (root.right != null) {
      root.right = helper(root.right, list);
    }
    return root;

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, 4, 5});
    findLeaves(treeNode);
  }

}
