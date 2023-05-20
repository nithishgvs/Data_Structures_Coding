package org.practice.io.ArraysAndHashing;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class LongestConsecutiveSequence_128 {


  public int longestConsecutive(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    int result = 1;

    Set<Integer> set = new LinkedHashSet<>();

    for (int i : nums) {
      set.add(i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i] - 1)) {
        continue;
      }
      int tempMax = 1;

      while (set.contains(nums[i] + 1)) {
        tempMax++;
        result = Math.max(result, tempMax);
        nums[i] = nums[i] + 1;
      }
    }

    return result;
  }

  @Test
  public void test() {
    System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
  }
}
