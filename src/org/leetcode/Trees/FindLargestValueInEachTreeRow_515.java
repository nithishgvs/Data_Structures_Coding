package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class FindLargestValueInEachTreeRow_515 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> largestValues(TreeNode root) {

    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> list = new ArrayList<>();

    Queue<TreeNode> queue1 = new ArrayDeque<>();
    Queue<TreeNode> queue2 = new ArrayDeque<>();

    queue1.add(root);

    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      int max = Integer.MIN_VALUE;
      boolean went = false;
      while (!queue1.isEmpty()) {
        went = true;
        TreeNode popped = ((ArrayDeque<TreeNode>) queue1).pollFirst();
        if (popped.left != null) {
          queue2.add(popped.left);
        }
        if (popped.right != null) {
          queue2.add(popped.right);
        }
        max = Math.max(popped.val, max);
      }
      if (went) {
        list.add(max);
        went = false;
      }

      max = Integer.MIN_VALUE;
      while (!queue2.isEmpty()) {
        went = true;
        TreeNode popped = ((ArrayDeque<TreeNode>) queue2).pollFirst();
        if (popped.left != null) {
          queue1.add(popped.left);
        }
        if (popped.right != null) {
          queue1.add(popped.right);
        }
        max = Math.max(popped.val, max);
      }
      if (went) {
        list.add(max);
      }
    }

    return list;
  }


  @Test
  public void testLargestInRow() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(3);
    treeNode.left.left = new TreeNode(5);
    treeNode.left.right = new TreeNode(3);
    treeNode.right = new TreeNode(2);
    treeNode.right.right = new TreeNode(9);

    List<Integer> out = largestValues(treeNode);
    out.stream().forEach(System.out::println);
  }


  @Test
  public void testLargestInRow1() {
    TreeNode treeNode = new TreeNode(-2147483648);

    List<Integer> out = largestValues(treeNode);
    out.stream().forEach(System.out::println);
  }

}
