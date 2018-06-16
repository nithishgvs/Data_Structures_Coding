package org.leetcode.Strings;

import org.junit.Test;

public class CountBinarySubstrings_696 {
	/**
	 * You have to practice more 
	 * @param s
	 * @return https://www.polarxiong.com/archives/LeetCode-696-count-binary-substrings.html
	 */
	public int countBinarySubstrings(String s) {
		int outCount = 0;
		int count1 = 1, count2 = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				count1++;
			} else {
				count2 = count1;
				count1 = 1;
			}
			if (count2 >= count1) {
				outCount++;
			}
		}
		return outCount;
	}

	@Test
	public void testCountBinarySubstrings() {
		String s = "00110011";
		String s2 = "10101";
		String s3 = "000111000";
		String s4 = "00100";
		System.out.println(countBinarySubstrings(s3));
	}

}
