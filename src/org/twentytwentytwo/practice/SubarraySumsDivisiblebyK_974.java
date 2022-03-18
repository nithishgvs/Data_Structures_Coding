package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class SubarraySumsDivisiblebyK_974 {


  public int subarraysDivByK(int[] nums, int k) {
    int count = 0;

    Map<Integer, List<Integer>> map = new HashMap<>();
    fillMap(map, 0, 1);

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder = sum % k;
      if (remainder < 0) {
        remainder += k;
      }
      if (map.containsKey(remainder)) {
        count += map.get(remainder).size();
      }
      fillMap(map, remainder, i);
    }

    return count;
  }

  private void fillMap(Map<Integer, List<Integer>> map, int value, int index) {
    if (!map.containsKey(value)) {
      map.put(value, new ArrayList<>());
    }
    map.get(value).add(index);
  }


  @Test
  public void test() {
    int[] nums = {4, 5, 0, -2, -3, 1};
    subarraysDivByK(nums, 5);
  }

  @Test
  public void test1() {
    int[] nums = {-1, 2, 9};
    subarraysDivByK(nums, 2);

  }
}
