package org.leetcode.Trees;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {

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
        inOrderRecursive(root);
        System.out.println();
        System.out.println("#########################");
        List<Integer> preOrderOut = preOrderTraversal(root);
        for (Integer val : preOrderOut) {
            System.out.print(val + " ");
        }

    }

    public void inOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.val + " ");
        inOrderRecursive(root.right);
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.right!=null)
                stack.add(node.right);
            if(node.left!=null)
                stack.add(node.left);
            preorder.add(node.val);
        }
        return preorder;
    }

}
