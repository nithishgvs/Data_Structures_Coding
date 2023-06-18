package org.practice.io.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class BinaryTreeRightSideView_199 {


  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode currentNode = queue.poll();
        if (i == size - 1) {
          result.add(currentNode.val);
        }
        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }
    }

    return result;

  }

  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4});
    rightSideView(treeNode);

  }
}
