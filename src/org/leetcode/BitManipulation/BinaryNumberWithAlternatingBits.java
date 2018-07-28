package org.leetcode.BitManipulation;

import org.junit.Test;

public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		boolean alternateFlag = true;
		int prev = 0;
		while (n > 0) {
			int digit = n % 2;
			if (!alternateFlag) {
				if (digit == prev)
					return false;
			}
			prev = digit;
			n = n / 2;
			alternateFlag = false;
		}
		return (n == 0);

	}

	@Test
	public void testBinaryNumberWithAlternatingBits() {
		hasAlternatingBits(5);
	}

}
