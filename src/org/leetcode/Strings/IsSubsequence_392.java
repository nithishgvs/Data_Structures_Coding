package org.leetcode.Strings;

import org.junit.Test;

public class IsSubsequence_392 {
	public boolean isSubsequence(String s, String t) {
		int index = 0;
		String temp = t;
		for (char c : s.toCharArray()) {
			if (temp.indexOf(c) + index >= index) {
				if (index != 0)
					index++;
				index += temp.indexOf(c);
				temp = t.substring(index + 1);
			} else {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testIsSubsequence() {

		String s = "twn", t = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
		String s2 = "ace", t2 = "abcde";
		System.out.println(isSubsequence(s, t));

	}
}
