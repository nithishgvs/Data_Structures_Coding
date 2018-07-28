package org.leetcode.Strings;

import org.junit.Test;

public class ConstructStringBinaryTree_606_Biscuit {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void preOrder(TreeNode root) {
		if (root == null) {
			System.out.print("Null-Node" + " ");
			return;
		}
		System.out.print(root.val + " ");
		if (root.left == null && root.right == null)
			return;
		preOrder(root.left);
		preOrder(root.right);
	}

	private TreeNode prepareTreeNode1() {
		TreeNode root = new TreeNode(1);
		// Left tree in Pic
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		// root.left.left = null;
		// Right tree in Pic
		root.right = new TreeNode(3);
		return root;
	}

	private TreeNode prepareTreeNode2() {
		TreeNode root = new TreeNode(1);
		// Left tree in Pic
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left = null;
		// Right tree in Pic
		root.right = new TreeNode(3);
		return root;
	}

	StringBuilder output = new StringBuilder();

	public String tree2str(TreeNode root) {
		if (root == null) return "";
        String s = "" + root.val;
        if (root.left != null || (root.left == null && root.right != null) ) {
            s += "(" + tree2str(root.left) + ")";
        }
        if (root.right != null){
            s += "(" + tree2str(root.right) + ")";
        }
        return s;
	}

	@Test
	public void test1() {
		TreeNode root = prepareTreeNode1();
		// preOrder(root);
		System.out.println();
		System.out.println(tree2str(root));
	}

}
