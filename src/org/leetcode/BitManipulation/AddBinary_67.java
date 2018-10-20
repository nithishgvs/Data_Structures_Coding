package org.leetcode.BitManipulation;

import org.junit.Test;

import java.util.Collections;

public class AddBinary_67 {

	public String addBinary(String a, String b) {
		String output = "";
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		b = String.join("", Collections.nCopies(a.length() - b.length(), "0")) + b;
		int carry = 0;
		int sum = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) == '1')
				sum++;
			if (b.charAt(i) == '1')
				sum++;
			if (sum + carry == 2) {
				output = "0" + output;
				carry = 1;
			} else if (sum + carry == 3) {
				output = "1" + output;
				carry = 1;
			} else if (sum + carry == 0) {
				output = "0" + output;
				carry = 0;
			} else if (sum + carry == 1) {
				output = "1" + output;
				carry = 0;
			}
			sum = 0;
		}

		if (carry == 0)
			return output;
		return carry + output;
	}

	@Test
	public void testBinaryAdd() {
		String a = "1010", b = "1011";
		String a1 = "0", b1 = "0";
		System.out.println(addBinary(a1, b1));
	}

}
