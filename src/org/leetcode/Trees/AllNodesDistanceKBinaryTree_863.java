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

public class AllNodesDistanceKBinaryTree_863 {

  Queue<TreeNode> queue = new ArrayDeque<>();
  Map<TreeNode, TreeNode> parentChildGraphMap = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    constructParentChildGraph(root, null, target);
    Set<TreeNode> visited = new HashSet<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      if (k == 0) {
        for (int i = 0; i < size; i++) {
          result.add(queue.poll().val);
        }
        break;
      }
      k--;
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        TreeNode parent = parentChildGraphMap.get(polled);
        if (polled.left != null && !visited.contains(polled.left)) {
          queue.add(polled.left);
          visited.add(polled.left);
        }
        if (polled.right != null && !visited.contains(polled.right)) {
          queue.add(polled.right);
          visited.add(polled.right);
        }
        if (parent != null && !visited.contains(parent)) {
          queue.add(parent);
        }
        visited.add(polled);
      }
    }

    return result;
  }

  private void constructParentChildGraph(TreeNode currentNode, TreeNode parent, TreeNode target) {
    if (currentNode == null) {
      return;
    }
    if (parent != null) {
      parentChildGraphMap.put(currentNode, parent);
    }
    if (currentNode == target) {
      queue.add(currentNode);
    }
    constructParentChildGraph(currentNode.left, currentNode, target);
    constructParentChildGraph(currentNode.right, currentNode, target);
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
    TreeNode treeNode = new HelperTree().generateBinaryTree(new Integer[]{0, 2, 1, null, null, 3});
    distanceK(treeNode, treeNode.right.left, 3);
  }

}
