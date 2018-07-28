package org.leetcode.Math;

import org.junit.Test;

public class ReverseInteger_7 {

	public int reverse(int x) {
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
			return 0;
		int value = 0;
		try {
			if (x < 0)
				value = -Integer.parseInt(new StringBuilder(String.valueOf(-x)).reverse().toString());
			else
				value = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
		} catch (NumberFormatException ex) {
			return 0;
		}
		return value;
	}

	@Test
	public void testReverse() {
		System.out.println(reverse(-2147483648));
		System.out.println(reverse(-1563847412));
		System.out.println(reverse(-123));
		System.out.println(-2147483647 < Integer.MIN_VALUE);

	}

}
