package org.leetcode.BitManipulation;

import org.junit.Test;

public class NumberOf1Bits_191 {

	public int hammingWeight(int n) {
		int ones = 0;
		String s = Integer.toBinaryString(n);
		for (char c : s.toCharArray()) {
			if (Character.getNumericValue(c) == 1) {
				ones++;
			}
		}
		return ones++;
	}

	@Test
	public void testHammingWeight() {
		System.out.println(hammingWeight(Integer.parseUnsignedInt("4294967295")));
	}

}
