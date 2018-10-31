package org.leetcode.Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateBinarySearchTree_98 {

    List<Integer> inOrderList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inOrderRecursive(root);
        List<Integer> sortedList = inOrderList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(sortedList);
        return sortedList.equals(inOrderList);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void treeTest() {
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
        System.out.println(isValidBST(root));
    }

    @Test
    public void treeTest1() {
        TreeNode root = new TreeNode(33);
        root.left = new TreeNode(33);
        System.out.println(isValidBST(root));
    }

    public void inOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursive(root.left);
        inOrderList.add(root.val);
        inOrderRecursive(root.right);
    }
}


