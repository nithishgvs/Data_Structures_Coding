package org.leetcode.Trees;

import org.junit.Test;

public class ConstructBstFromTraversals_105 {

	static int preIndex = 0;

	/**
	 * Practice again as I referred geeksforgeeks
	 * 
	 * @param inOrder
	 * @param preOrder
	 * @param inLow
	 * @param inHigh
	 * @return
	 */
	public static Node<Integer> constructUsingTraversals(int[] inOrder, int[] preOrder, int inLow, int inHigh) {
		if (inLow > inHigh) {
			return null;
		}
		Node<Integer> root = new Node<>(preOrder[preIndex++]);
		int rootIndex = findIndexRootBinarySearch(root.getData(), inOrder, inLow, inHigh);
		root.setLeftChild(constructUsingTraversals(inOrder, preOrder, inLow, rootIndex - 1));
		root.setRightChild(constructUsingTraversals(inOrder, preOrder, rootIndex + 1, inHigh));
		return root;
	}

	private static int findIndexRootBinarySearch(int rootElement, int[] inOrder, int low, int high) {
		int index = 0;

		while (low <= high) {
			int mid = (low + high) / 2 + (low + high) % 2;
			if (rootElement == inOrder[mid]) {
				index = mid;
				break;
			} else if (inOrder[mid] > rootElement) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return index;
	}

	@Test
	public void testLevelOrderTraversal() {
		int[] inOrderArray = { 12, 25, 27, 33, 34, 39, 48, 52, 60, 65, 72, 78, 90 };
		int[] preOrderArray = { 52, 33, 25, 12, 27, 39, 34, 48, 65, 60, 78, 72, 90 };
		Node<Integer> root = constructUsingTraversals(inOrderArray, preOrderArray, 0, inOrderArray.length - 1);
		InOrderTraversalBinaryTree<Integer> in = new InOrderTraversalBinaryTree<>();
		in.inOrderRecursive(root);
	}

	@Test
	public void testLevelOrderTraversal2() {
		int[] inOrderArray = { 1, 3, 4, 6, 5, 7, 8 };
		int[] preOrderArray = { 6, 3, 1, 4, 7, 5, 8 };
		Node<Integer> root = constructUsingTraversals(inOrderArray, preOrderArray, 0, inOrderArray.length - 1);
		InOrderTraversalBinaryTree<Integer> in = new InOrderTraversalBinaryTree<>();
		in.inOrderRecursive(root);
	}
}
