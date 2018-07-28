package org.leetcode.Strings;

import org.junit.Test;

public class RepeatedSubstringPattern_459 {

	/**
	 * copied code recheck
	 * 
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern(String s) {

		return (s + s).indexOf(s, 1) < s.length();
	}

	@Test

	public void repeatedSubstringPattern() {
		String x = "abab";
		System.out.println(repeatedSubstringPattern("abab"));
	}
}
