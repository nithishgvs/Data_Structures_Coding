package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {

  Map<Integer, List<Integer>> map;
  Random random;

  public Solution(int[] nums) {
    random = new Random();
    map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], new ArrayList<>());
      }
      map.get(nums[i]).add(i);
    }
  }

  public int pick(int target) {
    if (!map.containsKey(target)) {
      return -1;
    }
    List<Integer> curList = map.get(target);
    return curList.get(random.nextInt(curList.size()));
  }

  public static void main(String[] args) {
    Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
    solution.pick(
        3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
    solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
    solution.pick(
        3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
  }
}
