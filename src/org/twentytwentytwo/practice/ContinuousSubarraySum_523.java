package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ContinuousSubarraySum_523 {


  public boolean checkSubarraySum(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    int sum = 0;

    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder = sum % k;

      if (map.containsKey(remainder)) {
        if (i - map.get(remainder) >= 2) {
          return true;
        }
      } else {
        map.put(remainder, i);
      }
    }

    return false;

  }


  @Test
  public void test1() {
    int[] nums = {23, 2, 6, 4, 7};
    System.out.println(checkSubarraySum(nums, 6));
  }

  @Test
  public void test2() {
    int[] nums = {5, 0, 0, 0, 0};
    System.out.println(checkSubarraySum(nums, 3));
  }

}
