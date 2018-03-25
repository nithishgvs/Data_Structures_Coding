package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class LongestPalindromicSubstring_5 {
	public String longestPalindrome(String s) {
		int[][] array = new int[s.length()][s.length()];

		// Diagnol Condition
		for (int i = 0; i < s.length(); i++) {
			array[i][i] = 1;
		}

		// Filling up other than diagnol with Vivek's logic
		int l = 1;
		int posX = 0, posY = 0;
		int max = 0;
		while (l < array.length) {
			int i = 0;
			while (i < array.length) {
				int j = i + l;
				if (j < array.length) {
					if (s.charAt(i) == s.charAt(j)) {
						if (j - i == 1) {
							array[i][j] = array[i + 1][j - 1] + 2;
						} else if (array[i + 1][j - 1] != 0) {
							array[i][j] = array[i + 1][j - 1] + 2;
						}
						if (array[i][j] > max) {
							max = array[i][j];
							posX = i;
							posY = j;
						}
					} else {
						array[i][j] = 0;
					}
				}
				i++;
			}
			l = l + 1;
		}

		// Back track and find the subsequence
		char[] charArray = new char[array[posX][posY]];
		int startIndex = 0;
		int lastIndex = charArray.length - 1;

		int i = posX;
		int j = posY;
		while (startIndex <= lastIndex) {
			if (s.charAt(i) == s.charAt(j)) {
				charArray[startIndex] = s.charAt(i);
				charArray[lastIndex] = s.charAt(j);
				startIndex++;
				lastIndex--;
				i = i + 1;
				j = j - 1;
			}
		}
		return String.valueOf(charArray);
	}

	@Test
	public void testLongestPalindromicSubstring() {
		String input = "babadada";
		String input2 = "cbbd";
		System.out.println(String.valueOf(longestPalindrome(input2)));
	}

}
