package org.practice.io.Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class AmountOfTimeForBinaryTreeToBeInfected_2385 {

  Map<TreeNode, TreeNode> parentGraph = new HashMap<>();

  public int amountOfTime(TreeNode root, int start) {

    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    constructGraph(root, queue, start, null);

    int time = 0;

    boolean started = false;

    Set<Integer> visited = new HashSet<>();

    while (!queue.isEmpty()) {

      int value = queue.size();

      for (int i = 0; i < value; i++) {
        TreeNode treeNode = queue.poll();
        visited.add(treeNode.val);
        if (treeNode.left != null && !visited.contains(treeNode.left.val)) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null && !visited.contains(treeNode.right.val)) {
          queue.add(treeNode.right);
        }
        if (parentGraph.get(treeNode) != null && !visited.contains(parentGraph.get(treeNode).val)) {
          queue.add(parentGraph.get(treeNode));
        }
      }
      if (started) {
        time++;
      }
      started = true;
    }

    return time;

  }

  private void constructGraph(TreeNode root, Queue<TreeNode> queue, int start, TreeNode parent) {
    if (root == null) {
      return;
    }
    if (parent != null) {
      parentGraph.put(root, parent);
    }
    if (root.val == start) {
      queue.add(root);
    }
    constructGraph(root.left, queue, start, root);
    constructGraph(root.right, queue, start, root);
  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2});
    System.out.println(amountOfTime(treeNode, 3));

  }
}
