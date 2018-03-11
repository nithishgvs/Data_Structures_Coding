package org.leetcode.Arrays;

import org.junit.Test;

public class One_Two_BitChars_717 {

	public boolean isOneBitCharacter(int[] bits) {
		boolean flag = false;

		for (int i = 0; i < bits.length;) {
			if (bits[i] == 1) {
				if (bits[i + 1] == 1 || bits[i + 1] == 0) {
					i = i + 2;
				}
			} else if (i == bits.length - 1) {
				return true;
			} else {
				i++;
			}
		}

		return flag;
	}

	@Test
	public void testIsOneBitCharacter() {
		int[] bits = { 0,0};
		System.out.println(isOneBitCharacter(bits));

	}

}
