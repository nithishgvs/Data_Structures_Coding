package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=nPtARJ2cYrg Tree ->acyclic graph is the suggestion
 */
public class AllNodesDistanceKinBinaryTree_863 {

  Map<TreeNode, TreeNode> parentGraph = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    if (root == null || target == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();

    constructParentGraph(root, null, queue, target);

    Set<Integer> visited = new HashSet<>();

    int currentLevel = 0;

    List<Integer> wantedNodes = new ArrayList<>();

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      if (K == currentLevel) {
        for (int j = 0; j < queueSize; j++) {
          wantedNodes.add(queue.poll().val);
        }
        return wantedNodes;
      }
      for (int i = 0; i < queueSize; i++) {
        TreeNode current = queue.poll();
        if (visited.contains(current.val)) {
          continue;
        }
        if (current.left != null && !visited.contains(current.left.val)) {
          queue.add(current.left);
        }
        if (current.right != null && !visited.contains(current.right.val)) {
          queue.add(current.right);
        }
        TreeNode parent = parentGraph.get(current);
        if (parent != null && !visited.contains(parent.val)) {
          queue.add(parentGraph.get(current));
        }
        visited.add(current.val);
      }
      currentLevel++;
    }

    return wantedNodes;
  }

  private void constructParentGraph(TreeNode root, TreeNode parent, Queue<TreeNode> queue,
      TreeNode target) {
    if (root == null) {
      return;
    }
    if (parent != null) {
      parentGraph.put(root, parent);
    }
    if (root == target) {
      queue.add(root);
    }
    constructParentGraph(root.left, root, queue, target);
    constructParentGraph(root.right, root, queue, target);
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(3);

    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    distanceK(root, root.left, 3);
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{0, null, 1, null, 2, null, 3});
    distanceK(root, new TreeNode(1), 3).forEach(v -> System.out.println(v));
  }

  @Test
  public void test3() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{0, 1, null, 3, 2});
    distanceK(root, new TreeNode(2), 1).forEach(v -> System.out.println(v));
  }
}
