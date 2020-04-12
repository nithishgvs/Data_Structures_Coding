package org.leetcode.Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal_94 {

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
        List<Integer> inOrderOut = inorderTraversal(root);
        for (Integer val : inOrderOut) {
            System.out.print(val + " ");
        }

    }

    @Test
    public void treeTest2() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        inOrderRecursive(root);
        System.out.println();
        System.out.println("#########################");
        List<Integer> inOrderOut = inorderTraversal(root);
        for (Integer val : inOrderOut) {
            System.out.print(val + " ");
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else{
                current=stack.pop();
                inOrder.add(current.val);
                current=current.right;
            }
        }
        return inOrder;
    }

    public void inOrderRecursive(TreeNode root) {

        if (root == null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.val + " ");
        inOrderRecursive(root.right);

    }
}
