package org.lcfresh.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MedianofTwoSortedArrays_4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    for (int num : nums1) {
      minHeap.add(num);
    }
    for (int num : nums2) {
      minHeap.add(num);
    }

    int size = minHeap.size();

    if (size % 2 == 0) {
      int count = 0;
      while (!minHeap.isEmpty()) {
        if (count == size / 2 - 1) {
          return (double) (minHeap.poll() + minHeap.poll()) / 2;
        }
        count++;
        minHeap.poll();
      }

    } else {
      int count = 0;
      while (!minHeap.isEmpty()) {
        if (count == size / 2) {
          return minHeap.poll();
        }
        count++;
        minHeap.poll();
      }
    }

    return -1;
  }

  @Test
  public void test() {
    int[] nums1 = {2, 5};
    int[] nums2 = {1};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

}
