package org.leetcode.Arrays;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class MedianofTwoSortedArrays_4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < nums1.length; i++) {
      minHeap.add(nums1[i]);
    }

    for (int i = 0; i < nums2.length; i++) {
      minHeap.add(nums2[i]);
    }

    int counter = 0;

    int actualSize = minHeap.size();

    if (minHeap.size() % 2 == 0) {
      while (!minHeap.isEmpty()) {
        if (counter == actualSize / 2 - 1) {
          return (double) (minHeap.poll() + minHeap.poll()) / 2;
        }
        counter++;
        minHeap.poll();
      }
    } else {
      while (!minHeap.isEmpty()) {
        if (counter == actualSize / 2) {
          return minHeap.poll();
        }
        counter++;
        minHeap.poll();
      }
    }
    return -1;
  }

  @Test
  public void testFindMedian() {
    System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
  }

  @Test
  public void testFindMedian1() {
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }


  public static int indexOf(Pattern pattern, String s) {
    Matcher matcher = pattern.matcher(s);
    return matcher.find() ? matcher.start() : -1;
  }

  @Test
  public void testFindMedian2() {
    System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
  }
}
