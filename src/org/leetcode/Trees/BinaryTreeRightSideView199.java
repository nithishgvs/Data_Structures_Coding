package org.leetcode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class BinaryTreeRightSideView199 {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temporaryList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        temporaryList.add(polled.val);
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
      result.add(temporaryList.get(temporaryList.size() - 1));
    }

    return result;
  }

  @Test
  public void test1() {
    //1,2,3,null,5,null,4
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4});
    rightSideView(root).forEach(k -> System.out.println(k));
  }
}

