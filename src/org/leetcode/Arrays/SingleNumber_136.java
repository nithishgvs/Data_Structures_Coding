package org.leetcode.Arrays;

public class SingleNumber_136 {

	public int singleNumber(int[] array) {
		int num = 0;

		for (int i = 0; i < array.length; i++) {
			num = num ^ array[i];
		}
		return num;
	}

}
