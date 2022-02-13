package org.seanparshad.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class AllNodesDistanceKinBinaryTree_863 {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> nodes = new ArrayList<>();

    Map<TreeNode, TreeNode> parentTreeMap = new HashMap<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    constructGraph(parentTreeMap, root, target, queue, null);
    int level = 0;

    Set<Integer> visited = new HashSet<>();

    while (!queue.isEmpty()) {

      int size = queue.size();

      if (level == K) {
        for (int i = 0; i < size; i++) {
          nodes.add(queue.poll().val);
        }
        return nodes;
      }

      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        if (visited.contains(polled.val)) {
          continue;
        }

        if (polled.left != null && !visited.contains(polled.left.val)) {
          queue.add(polled.left);
        }
        if (polled.right != null && !visited.contains(polled.right.val)) {
          queue.add(polled.right);
        }
        TreeNode parent = parentTreeMap.get(polled);
        if (parent != null && !visited.contains(parent.val)) {
          queue.add(parent);
        }
        visited.add(polled.val);
      }
      level++;
    }

    return nodes;
  }

  private void constructGraph(Map<TreeNode, TreeNode> parentTreeMap, TreeNode currentNode,
      TreeNode target,
      Queue<TreeNode> queue, TreeNode parent) {
    if (currentNode == null) {
      return;
    }
    if (parent != null) {
      parentTreeMap.put(currentNode, parent);
    }
    if (currentNode == target) {
      queue.add(currentNode);
    }
    constructGraph(parentTreeMap, currentNode.left, target, queue, currentNode);
    constructGraph(parentTreeMap, currentNode.right, target, queue, currentNode);
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
    distanceK(root, root.left, 3).forEach(val -> System.out.println(val));
  }

  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    distanceK(root, new TreeNode(5), 2).forEach(val -> System.out.println(val));
  }
}
