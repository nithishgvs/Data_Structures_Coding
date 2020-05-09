package org.leetcode.SlidingWindowTechnique;

import org.junit.Test;

/**
 * ABBCCCA should return index 2 and length 3
 * 
 * @author nithishgvs
 *
 */
public class LongestSubStringRepeatedChars {

	public int[] longestSubStringWithRepeatedChars(String string) {
		int[] array = new int[2];

		int currentMax = 1;
		int startIndex = 0;

		for (int i = 0; i < string.length() - 1; i++) {
			if (string.charAt(i + 1) == string.charAt(i)) {
				currentMax++;
				if (currentMax > array[1]) {
					array[1] = currentMax;
					array[0] = startIndex;
				}
			} else {
				currentMax = 1;
				startIndex = i + 1;
			}
		}
		return array;
	}


	@Test
	public void testlongestSubStringWithRepeatedChars() {
		String string = "ABBCCCA";
		longestSubStringWithRepeatedChars(string);

	}

}
