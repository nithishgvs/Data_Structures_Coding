package org.leetcode.Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetMismatch_645 {


  public int[] findErrorNums(int[] nums) {
    int[] outputArray = new int[2];
    Set<Integer> numberSet = new HashSet<>();
    int actualSum = 0;
    int num = 0;

    int toBeSum = (nums.length * (nums.length + 1)) / 2;

    for (Integer number : nums) {
      actualSum += number;
      if (!numberSet.add(number)) {
        outputArray[0] = number;
        num = number;
      }
    }

    if (actualSum < toBeSum) {
      outputArray[1] = toBeSum - actualSum + num;
    } else {
      outputArray[1] = toBeSum - (actualSum - num);
    }

    return outputArray;
  }


  @Test
  public void testFindErrorNums() {
    int[] nums = {3, 2, 3, 4, 6, 5};
    System.out.println(Arrays.toString(findErrorNums(nums)));
  }


  @Test
  public void testFindErrorNums1() {
    int[] nums = {1, 2, 3, 3, 5};
    System.out.println(Arrays.toString(findErrorNums(nums)));
  }


}
