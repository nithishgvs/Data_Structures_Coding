package org.leetcode.Trees;

import org.junit.Test;

public class PathSum_112 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val - sum == 0)
			return true;
		else
			return hasPathSum(root.left, (sum - root.val)) || hasPathSum(root.right, (sum - root.val));
	}

	@Test
	public void hasPathSumTest() {
		System.out.println(hasPathSum(prepareTreeNode(), 212));
	}

	private TreeNode prepareTreeNode() {
		TreeNode root = new TreeNode(5);
		// Left tree in Pic
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		// Right tree in Pic
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		return root;
	}
}
