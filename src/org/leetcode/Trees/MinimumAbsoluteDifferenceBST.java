package org.leetcode.Trees;

import org.junit.Test;

import java.util.Stack;

public class MinimumAbsoluteDifferenceBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Inorder concept iterative
	 * 
	 * @param root
	 * @return
	 */
	public int getMinimumDifference2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int diff = Integer.MAX_VALUE;
		int prevPopped = Integer.MAX_VALUE;

		Stack<TreeNode> stack = new Stack<>();

		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				System.out.println(stack.peek().val);
				if (prevPopped != Integer.MAX_VALUE)
					diff = Math.min(Math.abs(prevPopped - stack.peek().val), diff);
				root = stack.peek().right;
				prevPopped = stack.pop().val;
			}

		}
		return diff;

	}

	int diff = Integer.MAX_VALUE;
	int prevPopped = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return 0;
		}
		inorderTraversal(root);
		return diff;

	}

	private void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		diff = Math.min(diff, Math.abs(root.val - prevPopped));
		prevPopped = root.val;
		inorderTraversal(root.right);

	}

	@Test
	public void testGetMinDiff() {

		prepareTreeNode();
		System.out.println(getMinimumDifference(prepareNode2()));

	}

	private TreeNode prepareTreeNode() {
		TreeNode root = new TreeNode(52);
		// Left tree in Pic
		root.left = new TreeNode(33);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(39);
		root.left.left.left = new TreeNode(12);
		root.left.left.right = new TreeNode(27);
		root.left.right.left = new TreeNode(34);
		root.left.right.right = new TreeNode(48);
		// Right tree in Pic
		root.right = new TreeNode(65);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(78);
		root.right.right.left = new TreeNode(72);
		root.right.right.right = new TreeNode(90);
		return root;
	}

	private TreeNode prepareNode2() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);

		return root;
	}

	private TreeNode prepareNode3() {
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(519);
		root.right.right = new TreeNode(1277);
		root.right.right.right = new TreeNode(2236);
		root.right.right.right.right = new TreeNode(2776);
		return root;
	}

}
