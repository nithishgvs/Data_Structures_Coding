package org.leetcode.Trees;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class UnivaluedBinaryTree_965 {


  public boolean isUnivalTree(TreeNode root) {

    Set<Integer> set = new HashSet<>();

    inOrderTraversal(root, set);

    return set.size() == 1;
  }

  private void inOrderTraversal(TreeNode root, Set<Integer> set) {

    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, set);
    set.add(root.val);
    if (set.size() > 1) {
      return;
    }
    inOrderTraversal(root.right, set);
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree.generateBinaryTree(new Integer[]{2,2,2,5,2});
    System.out.println(isUnivalTree(root));
  }
}
