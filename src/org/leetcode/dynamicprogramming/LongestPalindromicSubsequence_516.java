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
	 * @param input
	 * @return
	 */
	public static char[] LongestPalindromicSubsequence(String input) {
		int[][] array = new int[input.length()][input.length()];

		// Diagnol Condition
		for (int i = 0; i < input.length(); i++) {
			array[i][i] = 1;
		}

		// Filling up other than diagnol with Vivek's logic
		int l = 1;
		while (l < array.length) {
			int i = 0;
			while (i < array.length) {
				int j = i + l;
				if (j < array.length) {
					if (input.charAt(i) == input.charAt(j)) {
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
		char[] charArray = new char[array[0][input.length() - 1]];
		int lastIndex = charArray.length - 1;

		int i = 0;
		int j = input.length() - 1;
		while (startIndex <= lastIndex) {
			if (input.charAt(i) == input.charAt(j)) {
				charArray[startIndex] = input.charAt(i);
				charArray[lastIndex] = input.charAt(i);
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

		return charArray;
	}

	@Test
	public void testLongestPalindromicSubsequence() {
		String input = "adbgcfbea";
		System.out.println(String.valueOf(LongestPalindromicSubsequence(input)));
	}

}
