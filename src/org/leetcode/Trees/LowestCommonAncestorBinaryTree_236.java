package org.leetcode.Trees;

import org.junit.Test;

public class LowestCommonAncestorBinaryTree_236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        return null;
    }

    @Test
    public void treeTest2() {
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
        System.out.println(lowestCommonAncestor(root, root, root.right.right.right).val);
    }

    @Test
    public void treeTest1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(11);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right).val);
    }
}
