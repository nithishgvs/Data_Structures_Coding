package org.leetcode.Trees;


import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum_1302 {

  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    int sum = 0;

    while (!queue.isEmpty()) {

      int currentSize = queue.size();
      sum = 0;

      for (int i = 0; i < currentSize; i++) {

        TreeNode current = queue.poll();
        sum += current.val;
        if (current.right != null) {
          queue.add(current.right);
        }
        if (current.left != null) {
          queue.add(current.left);
        }
      }


    }

    return sum;
  }

}
