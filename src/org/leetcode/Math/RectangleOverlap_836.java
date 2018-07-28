package org.leetcode.Math;

import org.junit.Test;

public class RectangleOverlap_836 {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec2[0] < rec1[2] && rec2[1] < rec1[3] && rec1[0] < rec2[2] && rec1[1] < rec2[3])
			return true;
		return false;
	}

	@Test
	public void testRectangleOverlap() {
		int[] rec1 = { 0, 0, 1, 1 }, rec2 = { 1, 0, 2, 1 };
		int[] rec3 = { 0, 0, 2, 2 }, rec4 = { 1, 1, 3, 3 };
		int[] rec5 = { 7, 8, 13, 15 }, rec6 = { 10, 8, 12, 20 };
		System.out.println(isRectangleOverlap(rec5, rec6));
	}

}
