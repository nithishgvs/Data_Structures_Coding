package org.leetcode.Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class ReorganizeString_767 {

	public String reorganizeString(String S) {
		if (S == null || S.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : S.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));
		maxHeap.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			sb.append(entry.getKey());
			entry.setValue(entry.getValue() - 1);
			queue.add(entry);
			while (queue.size() > 1) {
				Map.Entry<Character, Integer> queuePoll = queue.poll();
				if (queuePoll.getValue() > 0)
					maxHeap.add(queuePoll);
			}
		}

		return sb.length() == S.length() ? sb.toString() : "";
	}

	@Test
	public void test() {
		String S = "baaba";
		String S2 = "aaab";
		// System.out.println(isEligible(S));
		System.out.println(reorganizeString(S2));
	}
}
