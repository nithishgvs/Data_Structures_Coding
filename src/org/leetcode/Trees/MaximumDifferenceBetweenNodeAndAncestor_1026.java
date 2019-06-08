package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int max = Integer.MIN_VALUE;

  public int maxAncestorDiff(TreeNode root) {
    return maxAncestorDiffHelper(root, new ArrayList<>(), max);
  }


  public int maxAncestorDiffHelper(TreeNode root, List<Integer> val, int max) {
    if (root != null) {
      val.add(root.val);
      Collections.sort(val);
      if (val.size() > 1) {
        max = Math.max(max, Math.abs(val.get(0) - val.get(val.size() - 1)));
      }
      return Math.max(maxAncestorDiffHelper(root.left, new ArrayList<>(val), max),
          maxAncestorDiffHelper(root.right, new ArrayList<>(val), max));
    }
    return max;
  }


  @Test
  public void testMaxAncestorDiff() {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right = new TreeNode(10);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(14);
    System.out.println(maxAncestorDiff(root));
  }

}
