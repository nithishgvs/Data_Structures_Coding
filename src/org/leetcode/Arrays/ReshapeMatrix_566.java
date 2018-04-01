package org.leetcode.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeMatrix_566 {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int[][] outputMatrix = new int[r][c];

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				queue.add(nums[i][j]);
			}
		}

		int elemPresent = queue.size();
		if (r * c > elemPresent) {
			return nums;
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				outputMatrix[i][j] = queue.poll();
			}
		}

		return outputMatrix;
	}

}
