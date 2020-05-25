package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class DeleteNodesAndReturnForest_1110 {


  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

    if (root == null) {
      return null;
    }

    Set<Integer> deleteSet = new HashSet<>();
    for (int del : to_delete) {
      deleteSet.add(del);
    }
    List<TreeNode> output = new ArrayList<>();

    dfsHelper(root, deleteSet, output);

    if(!deleteSet.contains(root.val)){
      output.add(root);
    }

    return output;

  }


  private TreeNode dfsHelper(TreeNode root, Set<Integer> deleteSet, List<TreeNode> output) {

    if (root == null) {
      return null;
    }

    root.left = dfsHelper(root.left, deleteSet, output);
    root.right = dfsHelper(root.right, deleteSet, output);

    if (deleteSet.contains(root.val)) {
      if (root.left != null) {
        output.add(root.left );
      }
      if (root.right != null) {
        output.add(root.right);
      }
      return null;
    }

    return root;


  }

  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    delNodes(treeNode, new int[]{1});

  }
}
