package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KthLargestElementArray_215 {

  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      if (minHeap.size() < k) {
        minHeap.add(nums[i]);
      } else if (minHeap.size() == k && minHeap.peek() < nums[i]) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }

    return minHeap.peek();
  }


  @Test
  public void testKthLargest1() {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
  }


  @Test
  public void testKthLargest2() {
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums, 4));
  }

  @Test
  public void testKthLargest3() {
    int[] nums = {2, 1};
    System.out.println(findKthLargest(nums, 2));
  }


}
