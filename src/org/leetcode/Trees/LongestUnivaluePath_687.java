package org.leetcode.Trees;

import org.junit.Test;

/**
 * Checked Discussion-- Recursion do more practice
 * 
 * @author nithishgvs
 *
 */
public class LongestUnivaluePath_687 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null)
			return 0;
		max = Math.max(longestPathHelper(root, Integer.MAX_VALUE), max);
		return max;
	}

	public int longestPathHelper(TreeNode root, int nodeVal) {
		if (root == null)
			return 0;
		if (root != null && root.val == nodeVal)
			return 1 + Math.max(longestPathHelper(root.left, nodeVal), longestPathHelper(root.right, nodeVal));
		else {
			int cur_max = longestPathHelper(root.left, root.val) + longestPathHelper(root.right, root.val);
			max = Math.max(max, cur_max);
			return 0;
		}

	}

	private TreeNode prepareTreeNode1() {
		TreeNode root = new TreeNode(5);
		// Left tree in Pic
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		// root.left.left = null;
		// Right tree in Pic
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		return root;
	}

	private TreeNode prepareTreeNode2() {
		TreeNode root = new TreeNode(1);
		// Left tree in Pic
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(4);
		// root.left.left = null;
		// Right tree in Pic
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		return root;
	}

	private TreeNode prepareTreeNode3() {
		TreeNode root = new TreeNode(4);
		// Left tree in Pic
		root.left = new TreeNode(-7);
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-9);
		root.right.left.left = new TreeNode(9);
		root.right.left.left.left = new TreeNode(6);
		root.right.left.left.left.left = new TreeNode(0);
		root.right.left.left.left.left.left = new TreeNode(-1);
		root.right.left.left.left.right = new TreeNode(6);
		root.right.left.left.left.right.left = new TreeNode(-4);
		// root.left.left = null;
		// Right tree in Pic

		root.right.right = new TreeNode(-3);
		root.right.right.left = new TreeNode(-4);
		root.right.left.right = new TreeNode(-7);
		root.right.left.right.left = new TreeNode(-6);
		root.right.left.right.left.left = new TreeNode(5);
		root.right.left.right.right = new TreeNode(-6);
		root.right.left.right.right.right = new TreeNode(9);
		root.right.left.right.right.right.right = new TreeNode(-2);
		return root;
	}

	@Test
	public void testLongestUnivaluePath() {
		TreeNode root = prepareTreeNode1();
		System.out.println(longestUnivaluePath(root));
	}

}
