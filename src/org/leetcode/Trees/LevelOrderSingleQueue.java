package org.leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSingleQueue {


  public void levelOrderTraversalSingleQueue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = ((LinkedList<TreeNode>) queue).pop();
        if (current.left != null) {
          ((LinkedList<TreeNode>) queue).add(current.left);
        }
        if (current.right != null) {
          ((LinkedList<TreeNode>) queue).add(current.right);
        }
      }
    }
  }

}
