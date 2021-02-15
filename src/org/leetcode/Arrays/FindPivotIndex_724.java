package org.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindPivotIndex_724 {

  public int pivotIndex(int[] nums) {
    int index = -1;

    Map<Integer, Integer> sumMap = new HashMap<>();

    if (nums.length <= 1) {
      return index;
    }

    for (int i = 0; i < nums.length; i++) {
      Integer value = sumMap.getOrDefault(i - 1, 0);
      sumMap.put(i, value + nums[i]);
    }

    int leftSum = 0, rightSum = 0;

    for (int i = 0; i < nums.length; i++) {
      leftSum = sumMap.getOrDefault(i - 1, 0);
      rightSum = sumMap.get(nums.length - 1) - sumMap.get(i);
      if (leftSum == rightSum) {
        return i;
      }
    }

    return index;

  }


  @Test
  public void test1() {
    System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    System.out.println(pivotIndex(new int[]{1, 2, 3}));
    System.out.println(pivotIndex(new int[]{2, 1, -1}));
  }

}
