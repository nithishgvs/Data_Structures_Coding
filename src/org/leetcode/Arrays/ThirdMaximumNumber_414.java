package org.leetcode.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class ThirdMaximumNumber_414 {

  public int thirdMax(int[] nums) {
    int max = Integer.MAX_VALUE;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int num : nums) {
      if (!maxHeap.contains(num)) {
        maxHeap.add(num);
      }
    }
    int k = 2;
    while (k > 0 && !maxHeap.isEmpty()) {
      int temp = maxHeap.poll();
      if (k == 2) {
        max = temp;
      }
      k--;
    }

    if (!maxHeap.isEmpty()) {
      return maxHeap.poll();
    }

    return max;
  }


  @Test
  public void test() {
    int[] nums = {1, 1, 1};
    System.out.println(thirdMax(nums));
  }

}
