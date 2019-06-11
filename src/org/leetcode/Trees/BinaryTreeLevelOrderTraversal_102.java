package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class BinaryTreeLevelOrderTraversal_102 {


  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> outputList = new ArrayList<>();

    if (root == null) {
      return outputList;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = ((ArrayDeque<TreeNode>) queue).pollFirst();
        list.add(treeNode.val);
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }
      outputList.add(list);
    }

    return outputList;
  }


  @Test
  public void testLevelOrder1() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    for (List<Integer> list : levelOrder(root)) {
      list.stream().forEach(v -> System.out.print(v + "->"));
      System.out.println();
    }
  }
}
