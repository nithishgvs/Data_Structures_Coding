package org.leetcode.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    LinkedList<List<Integer>> zigzagList = new LinkedList<>();
    if (root == null) {
      return zigzagList;
    }
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.add(root);
    LinkedList<Integer> aList = new LinkedList<>();

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      TreeNode current = null;
      while (!stack1.isEmpty()) {
        current = stack1.pop();
        aList.addFirst(current.val);
        if (current.right != null) {
          stack2.add(current.right);
        }
        if (current.left != null) {
          stack2.add(current.left);
        }
      }

      LinkedList<Integer> tempList = new LinkedList<>();
      tempList.addAll(aList);

      if (tempList.size() > 0) {
        zigzagList.addLast(tempList);
      }
      aList.clear();

      while (!stack2.isEmpty()) {
        current = stack2.pop();
        aList.addFirst(current.val);
        if (current.left != null) {
          stack1.add(current.left);
        }
        if (current.right != null) {
          stack1.add(current.right);
        }
      }

      tempList = new LinkedList<>();
      tempList.addAll(aList);

      if (tempList.size() > 0) {
        zigzagList.addLast(tempList);
      }
      aList.clear();
    }

    return zigzagList;
  }

  @Test
  public void treeTest() {

    TreeNode root = new TreeNode(52);
    root.left = new TreeNode(33);
    root.left.left = new TreeNode(25);
    root.left.left.left = new TreeNode(12);
    root.left.left.right = new TreeNode(27);
    root.left.right = new TreeNode(39);
    root.left.right.left = new TreeNode(34);
    root.left.right.right = new TreeNode(48);

    root.right = new TreeNode(65);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(78);
    root.right.right.left = new TreeNode(72);
    root.right.right.right = new TreeNode(90);
    zigzagLevelOrder(root);
    System.out.println("Done");
  }

  @Test
  public void treeTest2() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    zigzagLevelOrder(root);
  }

}
