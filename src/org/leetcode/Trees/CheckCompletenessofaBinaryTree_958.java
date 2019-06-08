package org.leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class CheckCompletenessofaBinaryTree_958 {


  public boolean isCompleteTree(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean edgeCaseSecondlevel = false;
    boolean levelIndicator = false;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode current = ((LinkedList<TreeNode>) queue).pop();
        if (current == null && queue.peek() != null) {
          return false;
        }
        if (levelIndicator && current != null) {
          if (current.right != null
              || current.left != null) {
            return false;
          }
        }
        if (current != null && current.left == null && current.right == null) {
          edgeCaseSecondlevel = true;
        }

        if (current != null) {
          ((LinkedList<TreeNode>) queue).add(current.left);
          ((LinkedList<TreeNode>) queue).add(current.right);
        }
      }
      levelIndicator = false;
      if (edgeCaseSecondlevel) {
        levelIndicator = true;
      }

    }

    return true;
  }


  @Test
  public void isCompleteTest1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    System.out.println(isCompleteTree(root));
  }

  @Test
  public void isCompleteTest2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(7);
    System.out.println(isCompleteTree(root));
  }


  @Test
  public void isCompleteTest3() {
    HelperTree helperTree = new HelperTree();
    org.leetcode.Trees.TreeNode node = helperTree
        .generateBinaryTree(new Integer[]{1, 2, 3, 5, null, 7, 8});
    System.out.println(isCompleteTree(node));

  }

  @Test
  public void isCompleteTest4() {
    HelperTree helperTree = new HelperTree();
    org.leetcode.Trees.TreeNode node = helperTree
        .generateBinaryTree(
            new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15});
    System.out.println(isCompleteTree(node));

  }


  @Test
  public void isCompleteTest5() {
    HelperTree helperTree = new HelperTree();
    org.leetcode.Trees.TreeNode node = helperTree
        .generateBinaryTree(
            new Integer[]{1, null, 2});
    System.out.println(isCompleteTree(node));

  }

  @Test
  public void isCompleteTest6() {
    HelperTree helperTree = new HelperTree();
    org.leetcode.Trees.TreeNode node = helperTree
        .generateBinaryTree(
            new Integer[]{1, 2, 3, 5, 6});
    System.out.println(isCompleteTree(node));

  }

}
