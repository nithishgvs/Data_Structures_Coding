package org.nithishgvs.binarytree;

import org.junit.Test;

public class UniqueBST_DP_96 {
	/**
	 * No of Unique Binary Search Trees for given number If k=3 1,2,3 are the
	 * inputs to construct Unique BST's
	 * 
	 * @param k
	 * @return
	 */
	public static int UniqueBST(int k) {
		int[] array = new int[k + 1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i <= k; i++) {
			for (int j = 0; j < i; j++) {
				array[i] += array[i - j - 1] * array[j];
			}

		}
		return array[k];
	}

	@Test
	public void testUniqueBST() {
		System.out.println(UniqueBST(4));
	}

}
