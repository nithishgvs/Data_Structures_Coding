package org.leetcode.Trees;


import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class CousinsInBinaryTree_993 {


  public class CousinChecker {

    TreeNode current;
    TreeNode parent;

    public CousinChecker(TreeNode current, TreeNode parent) {
      this.current = current;
      this.parent = parent;
    }
  }

  public boolean isCousins(TreeNode root, int x, int y) {

    Queue<CousinChecker> queue = new LinkedList<>();

    queue.add(new CousinChecker(root, null));

    boolean found = false;

    while (!queue.isEmpty()) {
      TreeNode firstParent = null;

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        CousinChecker node = queue.poll();
        if (node.current.val == x || node.current.val == y) {
          if (found) {
            return firstParent != node.parent;
          } else {
            found = true;
            firstParent = node.parent;
          }
        }
        if (node.current.left != null) {
          queue.add(new CousinChecker(node.current.left, node.current));
        }
        if (node.current.right != null) {
          queue.add(new CousinChecker(node.current.right, node.current));
        }
      }
      found = false;
      firstParent = null;
    }
    return false;

  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode node = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, 4});

    System.out.println(isCousins(node, 4, 3));
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode node = helperTree.generateBinaryTree(new Integer[]{1,2,3,null,4,null,5});

    System.out.println(isCousins(node, 5, 4));
  }
}
