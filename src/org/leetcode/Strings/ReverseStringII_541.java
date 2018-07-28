package org.leetcode.Strings;

import org.junit.Test;

public class ReverseStringII_541 {

	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			counter++;
			sb.append(s.charAt(i));
			if (counter == k) {
				if (!flag) {
					String substr = sb.substring((i + 1) - counter, sb.length());
					sb.replace((i + 1) - counter, sb.length(), new StringBuilder(substr).reverse().toString());
				}
				counter = 0;
				flag = !flag;
			}

		}
		if (counter > 0 && !flag) {
			String substr = sb.substring(s.length() - counter, sb.length());
			sb.replace(s.length() - counter, sb.length(), new StringBuilder(substr).reverse().toString());
		}

		return sb.toString();
	}

	@Test
	public void testReverseStr() {
		//System.out.println(reverseStr("abcdefg", 4));

		System.out.println(reverseStr(
				"fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",
				39));

	}

}
