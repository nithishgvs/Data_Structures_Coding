package org.leetcode.Arrays;

import org.junit.Test;

public class HappyNumber_202 {

	public boolean isHappy(int n) {
		return checkIsHappy(n);
	}

	private boolean checkIsHappy(int n) {
		if (n == 1)
			return true;
		int output = 0;
		while (n != 0) {
			int remainder = n % 10;
			output += Math.pow(remainder, 2);
			n = n / 10;
		}
		return checkIsHappy(output);
	}

	@Test
	public void testHappy() {
		checkIsHappy(2);
	}

}
