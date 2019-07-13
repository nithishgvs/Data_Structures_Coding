package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class FindKthSmallestPairDistance_719 {


  public int smallestDistancePair(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        minHeap.add(Math.abs(nums[i] - nums[j]));
      }
    }
    int i = 1;
    while (i < k) {
      minHeap.poll();
      i++;
    }

    return minHeap.poll();

  }

  @Test
  public void test1() {
    System.out.println(smallestDistancePair(new int[]{1, 3, 1}, 1));
  }

  @Test
  public void test2() {
    System.out.println(smallestDistancePair(new int[]{1, 1, 1}, 2));
  }
}
