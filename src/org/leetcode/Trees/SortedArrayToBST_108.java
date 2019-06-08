package org.leetcode.Trees;

import org.junit.Test;

import java.util.Arrays;

public class SortedArrayToBST_108 {

	/**
	 * LeetCode Number 108 .Convert Sorted Array to Binary Search Tree
	 * 
	 * @param array
	 * @return
	 */
	public static TreeNodeCustom sortedArrayToBST(int[] array) {
		if (array.length == 0) {
			return null;
		} else if (array.length == 1) {
			return new TreeNodeCustom(array[0]);
		}
		int mid = (array.length) / 2 + (array.length) % 2;
		TreeNodeCustom root = new TreeNodeCustom(array[mid]);
		int[] leftArray = Arrays.copyOfRange(array, 0, mid);
		int[] rightArray = Arrays.copyOfRange(array, mid + 1, array.length);
		root.setLeftChild(sortedArrayToBST(leftArray));
		root.setRightChild(sortedArrayToBST(rightArray));
		return root;
	}

	@Test
	public void sortedArrayToBstTest() {
		int[] array = { -2, 0, 1, 2, 3, 4, 5, 100 };
		BinarySearchTreeInsertion bst = new BinarySearchTreeInsertion();
		TreeNodeCustom output = sortedArrayToBST(array);
		System.out.println("InOrder traversal of this Output Tree");
		bst.inOrderRecursive(output);
	}

}
