package org.leetcode.Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> aList = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int num = i;
			while (num != 0) {
				int remainder = num % 10;
				if (remainder != 0 && i % remainder == 0)
					num = num / 10;
				else
					break;
			}
			if (num == 0)
				aList.add(i);

		}
		return aList;
	}

	@Test
	public void testSelfDividingNumbers() {
		System.out.println(selfDividingNumbers(12, 13));
	}

}
