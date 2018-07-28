package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ValidAnagram_242 {

	public boolean isAnagram(String s, String t) {

		HashMap<Character, Integer> sMap = new HashMap<>();

		for (char c : s.toCharArray())
			sMap.put(c, sMap.getOrDefault(c, 0) + 1);

		for (char c : t.toCharArray())
			sMap.put(c, sMap.getOrDefault(c, 0) - 1);

		for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
			Integer value = entry.getValue();
			if (value != 0)
				return false;
		}

		return true;
	}

	@Test
	public void testAnagram() {
		System.out.println(isAnagram("ab", "a"));
	}

}
