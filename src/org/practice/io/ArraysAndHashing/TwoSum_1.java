package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TwoSum_1 {

  public int[] twoSum(int[] nums, int target) {

    int[] result = new int[2];

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int residual = target - nums[i];
      if (map.containsKey(residual)) {
        result[0] = map.get(residual);
        result[1] = i;
        break;
      }
      map.put(nums[i], i);
    }
    return result;

  }

  @Test
  public void test1() {
    int[] nums = {3, 2, 4};
    twoSum(nums, 6);
  }
}
