package org.leetcode.SlidingWindowTechnique;

import java.util.PriorityQueue;
import org.junit.Test;

public class SlidingWindowMaximum_239 {


  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
      return new int[0];
    }
    int[] out = new int[nums.length - k + 1];
    int a = 0;
    for (int i = 0; i < nums.length; i++) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
      for (int j = i; j < i + k && j < nums.length; j++) {
        priorityQueue.add(nums[j]);
      }
      if (a < out.length) {
        out[a++] = priorityQueue.poll();
      }
    }

    return out;
  }


  @Test
  public void test1() {
    maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
