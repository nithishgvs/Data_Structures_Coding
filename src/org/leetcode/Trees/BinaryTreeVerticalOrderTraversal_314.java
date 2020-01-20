package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import org.junit.Test;

public class BinaryTreeVerticalOrderTraversal_314 {


  class TreeCustomNode {

    TreeNode treeNode;
    int val;

    public TreeCustomNode(TreeNode treeNode, int val) {
      this.treeNode = treeNode;
      this.val = val;
    }
  }


  public List<List<Integer>> verticalOrder(TreeNode root) {

    List<List<Integer>> output = new ArrayList<>();

    if (root == null) {
      return output;
    }

    Queue<TreeCustomNode> queue = new ArrayDeque<>();
    queue.add(new TreeCustomNode(root, 0));
    Map<Integer, List<Integer>> map = new HashMap<>();

    while (!queue.isEmpty()) {

      TreeCustomNode treeCustomNode = queue.poll();

      if (!map.containsKey(treeCustomNode.val)) {
        List<Integer> list = new ArrayList<>();
        list.add(treeCustomNode.treeNode.val);
        map.put(treeCustomNode.val, list);
      } else {
        map.get(treeCustomNode.val).add(treeCustomNode.treeNode.val);
      }

      if (treeCustomNode.treeNode.left != null) {
        queue.add(new TreeCustomNode(treeCustomNode.treeNode.left, treeCustomNode.val - 1));
      }
      if (treeCustomNode.treeNode.right != null) {
        queue.add(new TreeCustomNode(treeCustomNode.treeNode.right, treeCustomNode.val + 1));
      }
    }

    for (Integer key : new TreeSet<>(map.keySet())) {
      output.add(map.get(key));
    }

    return output;
  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    verticalOrder(helperTree.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}));
  }
}
