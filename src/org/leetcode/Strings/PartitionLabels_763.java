package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PartitionLabels_763 {

	// public List<Integer> partitionLabels(String S) {
	//
	// Map<Character, List<Integer>> hMap = new HashMap();
	// for (int i = 0; i < S.length(); i++) {
	// if (!hMap.containsKey(S.charAt(i))) {
	// List<Integer> tempList = new ArrayList<>();
	// tempList.add(i);
	// hMap.put(S.charAt(i), tempList);
	// } else {
	// List<Integer> tempList = new ArrayList<>(hMap.get(S.charAt(i)));
	// tempList.add(i);
	// hMap.put(S.charAt(i), tempList);
	// }
	//
	// }
	// List<Map.Entry<Character, List<Integer>>> list = new
	// LinkedList<Map.Entry<Character, List<Integer>>>(
	// hMap.entrySet());
	//
	// Collections.sort(list, new Comparator<Map.Entry<Character,
	// List<Integer>>>() {
	// public int compare(Map.Entry<Character, List<Integer>> o1,
	// Map.Entry<Character, List<Integer>> o2) {
	// return (o2.getValue().size() - o1.getValue().size());
	// }
	// });
	//
	// Map<Character, List<Integer>> sortedMap = new LinkedHashMap<Character,
	// List<Integer>>();
	// for (Map.Entry<Character, List<Integer>> entry : list) {
	// sortedMap.put(entry.getKey(), entry.getValue());
	// }
	//
	// return null;
	// }

	// public List<Integer> partitionLabels(String S) {
	// Set<Character> hSet = new LinkedHashSet<>();
	// List<Integer> partitions = new ArrayList<>();
	// String rev = new StringBuilder(S).reverse().toString();
	// int cut = 0;
	// int initialLength = S.length();
	// for (int i = 0; i < S.length(); i++) {
	// if (!hSet.add(S.charAt(i))) {
	// int currentIndex = Integer.MAX_VALUE;
	// for (Character ch : hSet) {
	// if (i >= initialLength)
	// break;
	// currentIndex = rev.indexOf(ch);
	// if (currentIndex != -1) {
	// cut = rev.length() - currentIndex;
	// rev = rev.substring(0, rev.length() - cut);
	// partitions.add(cut);
	// i = S.length() - currentIndex;
	// i = i - 1;
	// }
	// }
	// hSet.removeAll(hSet);
	// }
	// }
	// return partitions;
	// }

	public List<Integer> partitionLabels(String S) {
		List<Integer> partitions = new ArrayList<>();
		int[] map = new int[26];
		for (int i = 0; i < S.length(); i++) {
			map[S.charAt(i) - 'a'] = i;
		}
		int max = 0;
		int prev = -1;
		for (int i = 0; i < S.length(); i++) {
			if (map[S.charAt(i) - 'a'] > max)
				max = map[S.charAt(i) - 'a'];
			if (i == max) {
				partitions.add(max - prev);
				prev = max;
			}

		}
		return partitions;
	}

	@Test
	public void testPartition() {
		System.out.println(partitionLabels("caedbdedda"));
		//System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println("abc");// "caedbdedda"

	}

}
