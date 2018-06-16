package org.leetcode.Strings;

import org.junit.Test;

public class RepeatedStringMatch_686 {

	public int repeatedStringMatch(String A, String B) {
		int n = B.length() / A.length() + 1;
		StringBuilder sb = new StringBuilder(A);

		for (int i = 0; i <= n; i++) {
			if (!sb.toString().contains(B))
				sb.append(A);
			else
				return i + 1;
		}

		return -1;
	}

	@Test
	public void testRepeatedStringMatch() {
		String A = "bb";
		String B = "bbbbbbb";
		System.out.println(repeatedStringMatch(A, B));
	}

}
