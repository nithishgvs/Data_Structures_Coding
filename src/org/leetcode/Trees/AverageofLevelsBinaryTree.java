package org.leetcode.Trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null)
			return null;
		List<Double> avglevels = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		double sum = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode elem = queue.poll();
				sum += elem.val;
				if (elem.left != null)
					queue.add(elem.left);
				if (elem.right != null)
					queue.add(elem.right);
			}
			avglevels.add((double) sum / size);
			sum = 0;
		}
		return avglevels;

	}

	@Test
	public void testAverageofLevelsBinaryTree() {

		averageOfLevels(prepareTreeNode());

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
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.left = new TreeNode(9);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		return root;
	}

}
