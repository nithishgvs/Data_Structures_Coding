package org.practice.io.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.leetcode.Trees.TreeNode;

public class BinaryTreeLevelOrderTraversal_102 {


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentList=new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        currentList.add(current.val);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(currentList);
    }

    return result;

  }
}
