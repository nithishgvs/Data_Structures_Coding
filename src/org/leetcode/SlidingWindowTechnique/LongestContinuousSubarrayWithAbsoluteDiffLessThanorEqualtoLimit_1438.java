package org.leetcode.SlidingWindowTechnique;

import java.util.PriorityQueue;
import org.junit.Test;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit_1438 {


  public int longestSubarray(int[] nums, int limit) {
    //Sliding window
    if (nums.length == 1) {
      return 1;
    }

    int size = 1;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.intValue() - a.intValue());

    minHeap.add(nums[0]);
    maxHeap.add(nums[0]);

    for (int i = 0, j = i + 1; j < nums.length; ) {
      minHeap.add(nums[j]);
      maxHeap.add(nums[j]);

      if (Math.abs(minHeap.peek() - maxHeap.peek()) <= limit) {
        size = Math.max(size, j - i + 1);
        j++;
      } else {
        minHeap.remove(nums[i]);
        maxHeap.remove(nums[i]);
        i++;
        j++;
      }

    }

    return size;
  }


  @Test
  public void test1() {
    System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
  }

  @Test
  public void test2() {
    System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
  }

  @Test
  public void test3() {
    System.out.println(longestSubarray(new int[]{4, 8, 5, 1, 7, 9}, 6));
  }

}
