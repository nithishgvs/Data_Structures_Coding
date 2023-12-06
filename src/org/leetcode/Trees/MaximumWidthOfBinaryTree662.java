package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class MaximumWidthOfBinaryTree662 {

  class TreeDetails {

    TreeNode treeNode;
    int level;

    public TreeDetails(TreeNode treeNode, int level) {
      this.treeNode = treeNode;
      this.level = level;
    }
  }

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int max = 0;
    Deque<TreeDetails> queue = new ArrayDeque<>();
    queue.add(new TreeDetails(root, 0));

    while (!queue.isEmpty()) {

      int size = queue.size();
      max = Math.max(max, queue.peekLast().level - queue.peekFirst().level + 1);

      for (int i = 0; i < size; i++) {
        TreeDetails treeDetails = queue.poll();
        if (treeDetails.treeNode.left != null) {
          queue.add(new TreeDetails(treeDetails.treeNode.left, (2 * treeDetails.level)));
        }
        if (treeDetails.treeNode.right != null) {
          queue.add(new TreeDetails(treeDetails.treeNode.right, (2 * treeDetails.level) + 1));
        }
      }

    }
    return max;
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    root.right.right.right = new TreeNode(2);
    System.out.println(widthOfBinaryTree(root));
  }

  @Test
  public void test2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    System.out.println(widthOfBinaryTree(root));
  }
}
