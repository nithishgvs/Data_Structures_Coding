package org.leetcode.Strings;

import org.junit.Test;

public class ReverseString_344 {

	public String reverseString(String s) {
		if (s != null)
			return new StringBuffer(s).reverse().toString();
		return null;
	}

	@Test
	public void reverseStringTest() {
		System.out.println(reverseString("Hello"));
	}

}
