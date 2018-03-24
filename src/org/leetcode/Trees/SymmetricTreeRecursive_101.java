package org.leetcode.Trees;

public class SymmetricTreeRecursive_101 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null && root.right != null) {
			return checkSymmetric(root.left, root.right);
		} else if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}

	private boolean checkSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;

		if (left != null && right != null && left.val == right.val) {
			return (checkSymmetric(left.left, right.right)) && checkSymmetric(left.right, right.left);
		}
		return false;
	}

}
