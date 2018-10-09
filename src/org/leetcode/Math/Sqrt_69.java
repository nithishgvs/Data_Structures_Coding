package org.leetcode.Math;

import org.junit.Test;

public class Sqrt_69 {

	public int mySqrt2(int x) {
		return (int) Math.sqrt(x);
	}

	public int mySqrt(int x) {
		long result = 1;
		long temp = 1;
		while (result <= x) {
			temp++;
			result = temp * temp;
		}
		return (int) temp - 1;
	}

	@Test
	public void testSquareRoot() {
		System.out.println(mySqrt(2147395600));
		System.out.println(Integer.MAX_VALUE);
	}
}
