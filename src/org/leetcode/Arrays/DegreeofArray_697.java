package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class DegreeofArray_697 {

	public static int findShortestSubArray(int[] nums) {
		int output = Integer.MAX_VALUE;
		int degree = 0;

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(i);
				map.put(nums[i], newList);
			} else {
				ArrayList<Integer> oldList = map.get(nums[i]);
				oldList.add(i);
				map.put(nums[i], oldList);
			}
			degree = Math.max(map.get(nums[i]).size(), degree);
		}

		Iterator<ArrayList<Integer>> itr = map.values().iterator();
		while (itr.hasNext()) {
			ArrayList<Integer> value = itr.next();
			if (value.size() == degree) {
				output = Math.min(output, value.get(value.size() - 1) - value.get(0) + 1);
			}
		}

		return output;
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 2, 3, 1 };
		int[] nums2 = { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(findShortestSubArray(nums2));
	}

}
