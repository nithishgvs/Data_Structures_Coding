package org.leetcode.Strings;

import org.junit.Test;

import java.util.*;

public class SortCharactersByFrequency_451 {

	public String frequencySort(String s) {
		StringBuilder output = new StringBuilder();

		HashMap<Character, Integer> charMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!charMap.containsKey(c))
				charMap.put(c, 1);
			else
				charMap.put(c, charMap.get(c) + 1);
		}

		// Sort Map by values

		HashMap<Character, Integer> sortedValueMap = sortValues(charMap);
		for (Map.Entry<Character, Integer> entry : sortedValueMap.entrySet()) {
			String temp = "";
			temp += String.join("", Collections.nCopies(entry.getValue(), entry.getKey().toString()));
			output.append(temp);
		}
		return output.toString();
	}

	private HashMap<Character, Integer> sortValues(HashMap<Character, Integer> charMap) {
		List<Map.Entry<Character, Integer>> mapList = new LinkedList<>(charMap.entrySet());

		Collections.sort(mapList, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});

		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> entry : mapList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	@Test
	public void testFrequencySort() {
		System.out.println(frequencySort("cccaaa"));
	}
}
