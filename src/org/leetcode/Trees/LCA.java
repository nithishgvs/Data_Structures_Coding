package org.leetcode.Trees;

import org.junit.Test;

public class LCA {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    } else if (left != null && right == null) {
      return left;
    } else if (left == null && right != null) {
      return right;
    }
    return null;
  }

  @Test
  public void treeTest1() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(6);
    root.left.left=new TreeNode(2);
    root.left.right=new TreeNode(11);
    root.left.right.left=new TreeNode(9);
    root.left.right.right=new TreeNode(5);
    root.right=new TreeNode(8);
    root.right.right=new TreeNode(3);
    root.right.right.left=new TreeNode(7);

    System.out.println(lowestCommonAncestor(root, root.left.left, root.right.right).val);
  }

}
