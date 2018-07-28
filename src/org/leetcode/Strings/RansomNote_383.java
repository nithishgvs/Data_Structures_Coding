package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class RansomNote_383 {

	private Map<Character, Integer> charMap = null;

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> ransomMap = constructMap(ransomNote);
		Map<Character, Integer> magazineMap = constructMap(magazine);

		Set<Character> ransomKeys = ransomMap.keySet();

		for (Character ch : ransomKeys) {
			if (magazineMap.get(ch) != null && magazineMap.get(ch) >= ransomMap.get(ch)) {
				continue;
			}
			return false;
		}

		return true;
	}

	public Map<Character, Integer> constructMap(String str) {
		charMap = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (!charMap.containsKey(ch))
				charMap.put(ch, 1);
			else
				charMap.put(ch, charMap.get(ch) + 1);

		}
		return charMap;
	}

	@Test
	public void testRansomNote() {
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
	}
}
