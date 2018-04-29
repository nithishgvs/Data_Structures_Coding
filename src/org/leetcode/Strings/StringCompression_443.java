package org.leetcode.Strings;

import org.junit.Test;

public class StringCompression_443 {
	/**
	 * Check this again -Referred discussion
	 * 
	 * @param chars
	 * @return
	 */
	public int compress(char[] chars) {
		int index = 0;
		Character previous = null;
		for (int i = 0; i < chars.length; i++) {
			if (previous == null || chars[i] != previous) {
				chars[index++] = chars[i];
				previous = chars[i];
			} else {
				int count = 2;
				while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
					i++;
					count++;
				}
				String str = String.valueOf(count);
				for (char s : str.toCharArray()) {
					chars[index++] = s;
				}
			}
		}
		return index;
	}

	@Test
	public void testCompress() {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd' };
		char[] chars2 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		System.out.println(compress(chars2));
	}

}
