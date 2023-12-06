package org.leetcode.Trees;

public class LowestCommonAncestorOfABinarySearchTree_235 {

  /**
   * Search the nodes in a BST if(found) return node else return null
   *
   * When some node receives both Left and Right values as non null that is the :C
   */

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
    }

    return left != null ? left : right;
  }


}
