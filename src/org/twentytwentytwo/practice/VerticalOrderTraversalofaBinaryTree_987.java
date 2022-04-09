package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.Test;
import org.leetcode.Trees.HelperTree;
import org.leetcode.Trees.TreeNode;

public class VerticalOrderTraversalofaBinaryTree_987 {

  public class HelperTreeNode {

    private TreeNode treeNode;
    private int index;

    public HelperTreeNode(
        TreeNode treeNode, int index) {
      this.treeNode = treeNode;
      this.index = index;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    HelperTreeNode helperTreeNode = new HelperTreeNode(root, 0);
    Map<Integer, List<Integer>> map = new TreeMap<>();

    Queue<HelperTreeNode> queue = new LinkedList<>();
    queue.add(helperTreeNode);

    while (!queue.isEmpty()) {

      HelperTreeNode current = queue.poll();
      if (!map.containsKey(current.index)) {
        map.put(current.index, new ArrayList<>());
      }
      map.get(current.index).add(current.treeNode.val);

      if (current.treeNode.left != null) {
        int newIndex = current.index - 1;
        HelperTreeNode left = new HelperTreeNode(current.treeNode.left, newIndex);
        queue.add(left);
      }
      if (current.treeNode.right != null) {
        int newIndex = current.index + 1;
        HelperTreeNode right = new HelperTreeNode(current.treeNode.right, newIndex);
        queue.add(right);
      }

    }

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }

    return result;

  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, 4, 6, 5, 7});

    verticalTraversal(treeNode);
  }

}
