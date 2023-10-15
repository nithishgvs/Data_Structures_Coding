package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class AllNodesDistanceKinBinaryTree863 {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    Map<TreeNode, TreeNode> parentGraph = new HashMap<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    constructParentGraph(parentGraph, root, null, target, queue);
    int currentLevel = 0;
    Set<TreeNode> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      if (currentLevel == k) {
        for (int i = 0; i < size; i++) {
          result.add(queue.poll().val);
        }
        break;
      }

      for (int i = 0; i < size; i++) {
        TreeNode treeNode = queue.poll();
        if (!visited.contains(treeNode)) {
          if (treeNode.left != null && !visited.contains(treeNode.left)) {
            queue.add(treeNode.left);
          }
          if (treeNode.right != null && !visited.contains(treeNode.right)) {
            queue.add(treeNode.right);
          }
          if (parentGraph.containsKey(treeNode) && !visited.contains(parentGraph.get(treeNode))) {
            queue.add(parentGraph.get(treeNode));
          }
          visited.add(treeNode);
        }

      }
      currentLevel++;
    }
    return result;
  }

  private void constructParentGraph(Map<TreeNode, TreeNode> parentGraph, TreeNode currentNode,
      TreeNode parent, TreeNode target, Queue<TreeNode> queue) {
    if (currentNode == null) {
      return;
    }
    if (parent != null) {
      parentGraph.put(currentNode, parent);
    }
    if (currentNode == target) {
      queue.add(currentNode);
    }
    constructParentGraph(parentGraph, currentNode.left, currentNode, target, queue);
    constructParentGraph(parentGraph, currentNode.right, currentNode, target, queue);
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
