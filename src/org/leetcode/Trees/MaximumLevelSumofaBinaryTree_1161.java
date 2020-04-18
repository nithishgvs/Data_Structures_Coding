package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;


public class MaximumLevelSumofaBinaryTree_1161 {

  public int maxLevelSum(TreeNode root) {
    int finalLevel = 0;

    if (root == null) {
      return finalLevel;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int max = 0;
    int currentLevel = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      int current = 0;
      currentLevel++;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        current += node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      if (current > max) {
        finalLevel = currentLevel;
        max = current;
      }

    }

    return finalLevel;

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(
        new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127});
    System.out.println(maxLevelSum(treeNode));
  }

}
