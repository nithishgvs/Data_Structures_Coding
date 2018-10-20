package org.leetcode.Strings;

import org.junit.Test;

import java.util.*;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> output = new ArrayList<>();
		HashMap<String, Integer> wordsMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!wordsMap.containsKey(words[i]))
				wordsMap.put(words[i], 1);
			else
				wordsMap.put(words[i], wordsMap.get(words[i]) + 1);
		}

		// Sort Map by Values without loosing duplicates
		int i = 0;
		HashMap<String, Integer> sortedValueMap = sortbyValues(wordsMap);
		for (Map.Entry<String, Integer> entrySet : sortedValueMap.entrySet()) {
			if (i < k)
				output.add(entrySet.getKey());
			else
				break;
			i++;
		}
		return output;

	}

	private HashMap<String, Integer> sortbyValues(HashMap<String, Integer> wordsMap) {
		HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordsMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o2.getValue() == o1.getValue())
					return o1.getKey().compareTo(o2.getKey());
				return o2.getValue() - o1.getValue();
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;

	}

	@Test
	public void testFrequentWords() {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		String[] words2 = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		topKFrequent(words2, 4);
	}

}
