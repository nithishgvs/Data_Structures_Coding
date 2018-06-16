package org.leetcode.Strings;

import org.junit.Test;

public class RotatedDigits_788 {

	private boolean isValid(int N) {
		String in = String.valueOf(N);
		char[] out = new char[in.length()];

		for (int i = 0; i < in.length(); i++) {
			// Invalid Numbers
			if (in.charAt(i) == '3' || in.charAt(i) == '4' || in.charAt(i) == '7') {
				return false;
			}
			if (in.charAt(i) == '2')
				out[i] = '5';
			else if (in.charAt(i) == '5')
				out[i] = '2';
			else if (in.charAt(i) == '6')
				out[i] = '9';
			else if (in.charAt(i) == '9')
				out[i] = '6';
			else
				out[i] = in.charAt(i);
		}
		return (!in.equals(new String(out)));
	}

	public int rotatedDigits(int N) {
		int out = 0;
		for (int i = 1; i <= N; i++) {
			out += isValid(i) ? 1 : 0;
		}
		return out;
	}

	@Test
	public void testRotatedDigits() {
		System.out.println(rotatedDigits(2));
	}

}
