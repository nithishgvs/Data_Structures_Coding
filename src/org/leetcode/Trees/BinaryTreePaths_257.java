package org.leetcode.Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<String> output = new ArrayList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return output;
		if (root.left == null && root.right == null) {
			output.add(String.valueOf(root.val));
			return output;
		}

		treePaths(root.left, String.valueOf(root.val) + "->");
		treePaths(root.right, String.valueOf(root.val) + "->");
		return output;
	}

	private void treePaths(TreeNode node, String valueOf) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			output.add(valueOf + String.valueOf(node.val));
			return;
		}
		if (node != null) {
			treePaths(node.left, valueOf + String.valueOf(node.val) + "->");
			treePaths(node.right, valueOf + String.valueOf(node.val) + "->");
		}
		return;
	}

	@Test
	public void testPaths() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		// root.left.left = new TreeNodeCustom(4);
		root.left.right = new TreeNode(5);
		// root.left.left.left = new TreeNodeCustom(6);
		// root.left.left.right = new TreeNodeCustom(7);
		binaryTreePaths(root);
	}
}
