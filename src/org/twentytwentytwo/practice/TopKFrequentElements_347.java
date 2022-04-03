package org.twentytwentytwo.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import org.junit.Test;

public class TopKFrequentElements_347 {

  public int[] topKFrequent(int[] nums, int k) {

    int[] result = new int[k];

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      Integer value = map.getOrDefault(num, 0);
      map.put(num, ++value);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        Comparator.comparingInt(Map.Entry::getValue));

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll().getKey();
    }

    return result;

  }


  @Test
  public void test() {
    int[] nums = {1, 1, 1, 2, 2, 3};
    topKFrequent(nums, 2);
  }

}
