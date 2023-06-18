package org.practice.io.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {


  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    boolean flag = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentList = new ArrayList<>();
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
      if (!flag) {
        Collections.reverse(currentList);
      }
      result.add(currentList);
      flag = !flag;
    }

    return result;
  }

  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    zigzagLevelOrder(treeNode);
  }
}
