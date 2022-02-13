package org.twentytwentytwo.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class AverageOfLevelsInBinaryTree_637 {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> avgLevels = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      double levelAvg = 0;
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        levelAvg += polled.val;
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
      avgLevels.add(levelAvg / size);
    }

    return avgLevels;
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    averageOfLevels(treeNode);

  }

}
