package org.practice.io.TwoPointers;

import org.junit.Test;

public class TwoSumIIInputArrayIsSorted_167 {

  public int[] twoSum(int[] numbers, int target) {

    int[] result = new int[2];

    int start = 0;
    int end = numbers.length - 1;

    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum == target) {
        result[0] = start + 1;
        result[1] = end + 1;
        break;
      } else if (sum > target) {
        end--;
      } else if (sum < target) {
        start++;
      }
    }
    return result;

  }

  @Test
  public void test() {
    int[] nums = {2, 7, 11, 15};
    twoSum(nums, 9);
  }

}
