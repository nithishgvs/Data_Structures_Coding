package org.leetcode.Strings;

import org.junit.Test;

public class ValidPalindromeII_680 {

	public boolean palindromeHelper(String s, int l, int h) {
		while (l < h) {
			if (s.charAt(l) == s.charAt(h)) {
				l++;
				h--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean validPalindrome(String s) {

		int l = 0;
		int h = s.length() - 1;

		while (l < h) {
			if (s.charAt(l) == s.charAt(h)) {
				l++;
				h--;
			} else if (l == h - 1) {
				return true;
			} else {
				return palindromeHelper(s, l, h - 1) || palindromeHelper(s, l + 1, h);
			}
		}

		return true;
	}

	@Test

	public void testPalindrome() {
		System.out.println(validPalindrome("deeeee"));
	}
}
