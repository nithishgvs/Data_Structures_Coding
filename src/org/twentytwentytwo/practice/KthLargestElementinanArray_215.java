package org.twentytwentytwo.practice;

import java.util.PriorityQueue;
import org.junit.Test;

public class KthLargestElementinanArray_215 {

  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();

  }


  @Test
  public void test(){
    int[] nums={3,2,3,1,2,4,5,5,6};
    System.out.println(findKthLargest(nums,4));
  }
}
