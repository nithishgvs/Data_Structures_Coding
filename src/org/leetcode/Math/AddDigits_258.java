package org.leetcode.Math;

import org.junit.Test;

public class AddDigits_258 {

	public int addDigits(int num) {
		int output = 0;

		while (num / 10 != 0) {
			String number = String.valueOf(num);
			for (char ch : number.toCharArray()) {
				output += Integer.parseInt(Character.toString(ch));
			}
			num = output;
			output = 0;
		}
		return num;

	}

	@Test
	public void testAddDigits() {
		System.out.println(addDigits(38));

	}
}
