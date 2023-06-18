package org.practice.io.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class AverageOfLevelsinBinaryTree_637 {


  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        sum += current.val;

        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(sum / size);
    }

    return result;

  }


  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    averageOfLevels(treeNode);
  }

}
