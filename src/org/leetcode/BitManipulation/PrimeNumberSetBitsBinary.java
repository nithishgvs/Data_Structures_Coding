package org.leetcode.BitManipulation;

import org.junit.Test;

public class PrimeNumberSetBitsBinary {
	public int countPrimeSetBits(int L, int R) {
		int count = 0;

		for (int i = L; i <= R; i++) {
			int binaryCount = binaryOneCounts(i);
			if (isPrime(binaryCount))
				count++;
		}
		return count;

	}

	public int binaryOneCounts(int num) {
		int count = 0;
		while (num > 0) {
			int digit = num % 2;
			if (digit == 1)
				count++;
			num = num / 2;
		}
		return count;
	}

	public boolean isPrime(int number) {
		if (number < 2)
			return false;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	@Test
	public void testPrimeNumberSetBitsBinary() {
		System.out.println(countPrimeSetBits(10, 15));
	}
}
