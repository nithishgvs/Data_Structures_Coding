package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class SubarraySumEqualsK_560 {


  public int subarraySum(int[] nums, int k) {
    int output = 0;
    int currentSum = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    fillMap(map, 0, 1);

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      if (map.containsKey(currentSum - k)) {
        output += map.get(currentSum - k).size();
      }

      fillMap(map, currentSum, i);
    }

    return output;
  }

  public void fillMap(Map<Integer, List<Integer>> map, Integer key, Integer value) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }

    map.get(key).add(value);
  }

  @Test
  public void test1() {
    int[] nums = {1, 1, 1};
    System.out.println(subarraySum(nums, 2));
  }

  @Test
  public void testSubArraySum2() {
    int[] nums = {3, 4, -7, 1, 3, 3, 1, -4};
    System.out.println(subarraySum(nums, 7));
  }
}
