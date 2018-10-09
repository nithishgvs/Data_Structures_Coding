package org.leetcode.Strings;

import org.junit.Test;

public class ValidPalindrome_125 {

	public static boolean isValidPalindrome(String input) {
		input = input.replaceAll("[^a-zA-Z0-9]", "");
		input = input.toLowerCase();
		String output = new StringBuffer(input).reverse().toString();

		if (output.equals(input))
			return true;

		return false;
	}

	@Test
	public void testValidPalindrome() {
		String input = "A man, a plan, a canal: Panama";
		String in="0P";
		System.out.println(isValidPalindrome(in));
	}

}
