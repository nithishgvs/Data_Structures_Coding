package org.leetcode.Trees;

import org.junit.Test;

public class ConstructBinaryTreeInPostTraversals_106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int l, int h, int postIndex) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        if (l == h)
            return new TreeNode(inorder[l]);
        if (l > h)
            return new TreeNode(inorder[l - h + 1]);
        int element = postorder[postIndex];
        int rootIndex = binarySearch(inorder, element, l, h);
        if (rootIndex == -1)
            return null;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, h, postIndex - 1);
        root.left = buildTreeHelper(inorder, postorder, l, rootIndex - 1, rootIndex - 1);
        return root;
    }

    private int binarySearch(int[] inorder, int element, int l, int h) {
        int i = 0;
        for (i = l; i <= h; i++) {
            if (inorder[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Test

    public void testConstructTree() {

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postOrder = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postOrder);
        inOrderRecursive(root);

    }

    @Test
    public void testConstructTree2() {

        int[] inorder = { 12, 25, 27, 33, 34, 39, 48, 52, 60, 65, 72, 78, 90 };
        int[] postOrder = { 12, 27, 25, 34, 48, 39, 33, 60, 72, 90, 78, 65, 52 };
        TreeNode root = buildTree(inorder, postOrder);
        inOrderRecursive(root);

    }

    @Test
    public void testConstructTree3() {

        int[] inorder = { 1, 2, 3, 4 };
        int[] postOrder = { 3, 2, 4, 1 };

        TreeNode root = buildTree(inorder, postOrder);
        inOrderRecursive(root);

    }

    public void inOrderRecursive(TreeNode root) {

        if (root == null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.val + " ");
        inOrderRecursive(root.right);

    }

}
