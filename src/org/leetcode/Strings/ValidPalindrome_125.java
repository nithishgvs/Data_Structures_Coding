package org.leetcode.Strings;

import org.junit.Test;

public class ValidPalindrome_125 {

	public static boolean isValidPalindrome(String input) {
		input = input.replaceAll("[^a-zA-Z]", "");
		input = input.toLowerCase();

		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) == input.charAt(input.length() - 1 - i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testValidPalindrome() {
		String input = "MADAM!,";
		System.out.println(isValidPalindrome(input));
	}

}
