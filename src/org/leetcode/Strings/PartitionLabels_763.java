package org.leetcode.Strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {

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
