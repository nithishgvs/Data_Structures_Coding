package org.leetcode.Arrays;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MajorityElement_169 {

	public int majorityElement(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + 1);
			else
				map.put(nums[i], 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
				new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						// TODO Auto-generated method stub
						return o2.getValue() - o1.getValue();
					}
				});

		for (Map.Entry<Integer, Integer> val : map.entrySet())
			heap.add(val);

		if (heap.peek().getValue() > nums.length / 2)
			return heap.peek().getKey();

		return -1;

	}

	@Test
	public void testMajElement() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(nums));
	}

}
