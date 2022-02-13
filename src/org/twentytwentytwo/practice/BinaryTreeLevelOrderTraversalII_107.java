package org.twentytwentytwo.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class BinaryTreeLevelOrderTraversalII_107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        currentList.add(polled.val);
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
      result.add(0, currentList);
    }
    return result;
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    levelOrderBottom(treeNode);

  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = null;
    levelOrderBottom(treeNode);

  }

}
