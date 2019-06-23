package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class BinaryTreeRightSideView_199 {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    ((LinkedList<TreeNode>) queue).add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = ((LinkedList<TreeNode>) queue).poll();
        if (i == size - 1) {
          list.add(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return list;
  }

  @Test
  public void test1() {
    //1,2,3,null,5,null,4
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4});
    rightSideView(root).forEach(k -> System.out.println(k));
  }

}
