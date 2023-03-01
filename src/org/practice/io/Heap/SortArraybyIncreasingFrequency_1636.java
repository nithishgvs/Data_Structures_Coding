package org.practice.io.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class SortArraybyIncreasingFrequency_1636 {

  public int[] frequencySort(int[] nums) {

    int[] result = new int[nums.length];

    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int val = freqMap.getOrDefault(nums[i], 0);
      freqMap.put(nums[i], ++val);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        (o1, o2) -> {
          if (o2.getValue() == o1.getValue()) {
            return o2.getKey() - o1.getKey();
          }
          return o1.getValue() - o2.getValue();
        });

    minHeap.addAll(freqMap.entrySet());
    int index = 0;
    while (!minHeap.isEmpty()) {
      Map.Entry<Integer, Integer> poll = minHeap.poll();
      for (int i = 0; i < poll.getValue(); i++) {
        result[index] = poll.getKey();
        index++;
      }
    }

    return result;

  }

  @Test
  public void test1(){
    frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
  }

}
