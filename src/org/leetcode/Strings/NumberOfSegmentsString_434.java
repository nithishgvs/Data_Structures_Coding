package org.leetcode.Strings;

import org.junit.Test;

public class NumberOfSegmentsString_434 {

	public int countSegments(String s) {
		if (s.length() == 0)
			return 0;

		int count = 0;

		if (s.charAt(0) != ' ')
			count++;
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
				count++;
			}
		}

		return count;

	}

	@Test
	public void testCountSegments() {
		String s = "                ";
		String s2 = ", , , ,        a, eaefa";
		String s3 = "";
		String s4 = ",,,,,ae%333**** 7 8 7 10";
		System.out.println(countSegments(s2));
	}

}
