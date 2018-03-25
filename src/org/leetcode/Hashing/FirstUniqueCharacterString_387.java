package org.leetcode.Hashing;

import java.util.HashMap;

import org.junit.Test;

public class FirstUniqueCharacterString_387 {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!hMap.containsKey(s.charAt(i))) {
				hMap.put(s.charAt(i), 1);
			} else {
				hMap.put(s.charAt(i), hMap.get(s.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (hMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		int[] array = new int[256];

		for (char c : s.toCharArray()) {
			array[c]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (array[s.charAt(i)] == 1) {
				return i;
			}
		}

		return -1;

	}

	@Test
	public void testFirstUniqIndex() {
		String s = "loveleetcode";
		System.out.println(firstUniqChar2(s));

	}

}
