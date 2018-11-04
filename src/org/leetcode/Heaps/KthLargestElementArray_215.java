package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KthLargestElementArray_215 {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
    priorityQueue.add(Integer.MIN_VALUE);
    for (int i = 0; i < nums.length; i++) {
      if (priorityQueue.peek() < nums[i]) {
        if (priorityQueue.size() == k) {
          priorityQueue.poll();
        }
        priorityQueue.add(nums[i]);
      }
    }
    return priorityQueue.poll();
  }


  @Test
  public void testKthLargest1() {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
  }


  @Test
  public void testKthLargest2() {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    System.out.println(findKthLargest(nums, 4));
  }

  @Test
  public void testKthLargest3() {
    int[] nums = {2,1};
    System.out.println(findKthLargest(nums, 2));
  }


}
