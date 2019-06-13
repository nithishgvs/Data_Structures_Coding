package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;


public class FindBottomLeftTreeValue_513 {

  public int findBottomLeftValue(TreeNode root) {

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int bottomLeft = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = ((ArrayDeque<TreeNode>) queue).pop();
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
        if (i == 0) {
          bottomLeft = current.val;
        }
      }
    }

    return bottomLeft;

  }

  private TreeNode prepareTreeNode1() {
    TreeNode root = new TreeNode(5);
    // Left tree in Pic
    root.left = new TreeNode(4);
    root.left.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    // root.left.left = null;
    // Right tree in Pic
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(5);
    return root;
  }


  @Test
  public void testBottomLeft() {
    System.out.println(findBottomLeftValue(prepareTreeNode1()));
  }
}
