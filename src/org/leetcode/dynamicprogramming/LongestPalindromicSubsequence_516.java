package org.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * Dedicated to Vivek Khyade
 * 
 * @author nithishgvs
 *
 */
public class LongestPalindromicSubsequence_516 {
	/**
	 * Here Backtrack and find the substring dont just return the size
	 * 
	 * @param s
	 * @return
	 */
	public static int LongestPalindromicSubsequence(String s) {
		int[][] array = new int[s.length()][s.length()];

		// Diagnol Condition
		for (int i = 0; i < s.length(); i++) {
			array[i][i] = 1;
		}

		// Filling up other than diagnol with Vivek's logic
		int l = 1;
		while (l < array.length) {
			int i = 0;
			while (i < array.length) {
				int j = i + l;
				if (j < array.length) {
					if (s.charAt(i) == s.charAt(j)) {
						array[i][j] = array[i + 1][j - 1] + 2;
					} else {
						array[i][j] = Math.max(array[i][j - 1], array[i + 1][j]);
					}
				}
				i++;
			}
			l = l + 1;
		}

		// Back track and find the subsequence
		int startIndex = 0;
		char[] charArray = new char[array[0][s.length() - 1]];
		int lastIndex = charArray.length - 1;

		int i = 0;
		int j = s.length() - 1;
		while (startIndex <= lastIndex) {
			if (s.charAt(i) == s.charAt(j)) {
				charArray[startIndex] = s.charAt(i);
				charArray[lastIndex] = s.charAt(i);
				i = i + 1;
				j = j - 1;
				startIndex++;
				lastIndex--;
			} else {
				if (array[i][j - 1] >= array[i + 1][j]) {
					j = j - 1;
				} else {
					i = i + 1;
				}
			}
		}

		return charArray.length;
	}

	@Test
	public void testLongestPalindromicSubsequence() {
		String input = "adbgcfbea";
		System.out.println(String.valueOf(LongestPalindromicSubsequence(input)));
	}

}
