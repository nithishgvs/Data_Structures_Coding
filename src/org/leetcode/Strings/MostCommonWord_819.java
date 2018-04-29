package org.leetcode.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class MostCommonWord_819 {

	public String mostCommonWord(String paragraph, String[] banned) {
		String output = null;
		String array = paragraph.toLowerCase().replaceAll("[^a-z\\s+]", "");
		String[] splitStr = array.split("\\s+");
		HashMap<String, Integer> countMap = new HashMap<>();
		HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

		for (int i = 0; i < splitStr.length; i++) {
			if (!bannedSet.contains(splitStr[i])) {
				if (countMap.containsKey(splitStr[i])) {
					countMap.put(splitStr[i], countMap.get(splitStr[i]) + 1);
				} else {
					countMap.put(splitStr[i], 1);
				}
			}
		}
		output = Collections.max(countMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
				.getKey();
		return output;
	}

	@Test
	public void testMostCommonWord() {
		String paragraph = "Bob! hit a ball, the hit BALL flew far after it was hit.";
		String[] bannedwords = new String[] { "hit" };
		System.out.println(mostCommonWord(paragraph, bannedwords));
	}

}
