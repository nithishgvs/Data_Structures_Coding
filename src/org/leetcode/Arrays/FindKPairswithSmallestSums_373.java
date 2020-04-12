package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class FindKPairswithSmallestSums_373 {


  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> output = new ArrayList<>();

    if (nums1.length == 0 || nums2.length == 0 || k < 1) {
      return output;
    }

    List<List<Integer>> tempArray = new LinkedList<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        List<Integer> list = new ArrayList<>();
        list.add(nums1[i]);
        list.add(nums2[j]);
        tempArray.add(list);
      }
    }

    PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
      return (a.get(0) + a.get(1)) - (b.get(0) + b.get(1));
    }
    );

    for (List<Integer> sub : tempArray) {
      List<Integer> list = new ArrayList<>();
      list.add(sub.get(0));
      list.add(sub.get(1));
      priorityQueue.add(list);
    }

    int i = 0;

    while (!priorityQueue.isEmpty() && i < k) {
      output.add(priorityQueue.poll());
      i++;
    }

    return output;

  }


  @Test
  public void test() {
    kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
  }

}
