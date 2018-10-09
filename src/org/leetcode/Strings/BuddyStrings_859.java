package org.leetcode.Strings;

import org.junit.Test;

public class BuddyStrings_859 {

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.compareTo(B) == 0) {
			if (A.substring(0, A.length() / 2).equals(A.substring(A.length() / 2, A.length()))
					&& A.substring(0, A.length() / 2).length() > 0) {
				return true;
			}
		}

		int remainder = 0;
		int count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				if (count > 2)
					return false;
				remainder += (A.charAt(i) - B.charAt(i));
				count++;
			}
		}
		return (remainder == 0 && count == 2);
	}

	@Test
	public void testBuddyStrings() {
		System.out.println("b".compareTo("b"));
		System.out.println("aaaaaaabc".compareTo("aaaaaaacb"));
		String A = "abab", B = "abab";
		String C = "", D = "";
		System.out.println(buddyStrings(C, D));
		System.out.println(A.substring(0, A.length() / 2) + " " + A.substring(A.length() / 2, A.length()));
	}
}
