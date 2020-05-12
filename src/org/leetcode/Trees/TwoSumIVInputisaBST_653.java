package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class TwoSumIVInputisaBST_653 {


  public boolean findTarget(TreeNode root, int k) {

    if (root == null) {
      return false;
    }
    return helper(root, k);

  }

  private boolean helper(TreeNode root, int k) {

    Set<Integer> set = new HashSet<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    while (!queue.isEmpty()) {

      TreeNode treeNode = queue.poll();
      if (set.contains(k - treeNode.val)) {
        return true;
      }

      set.add(treeNode.val);

      if (treeNode.left != null) {
        queue.add(treeNode.left);
      }
      if (treeNode.right != null) {
        queue.add(treeNode.right);
      }

    }

    return false;
  }


  @Test
  public void test() {

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    System.out.println(findTarget(root, 9));


  }
}
