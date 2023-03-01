package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class TopKFrequentElements_247 {

  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : nums) {
      int value = freqMap.getOrDefault(num, 0);
      freqMap.put(num, ++value);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
    pq.addAll(freqMap.entrySet());

    int[] result = new int[k];
    int i = 0;
    while (!pq.isEmpty() && k > 0) {
      result[i] = pq.poll().getKey();
      i++;
      k--;
    }

    return result;
  }

  @Test
  public void test(){
    topKFrequent(new int[]{1,1,1,2,2,3},2);
    topKFrequent(new int[]{1},1);
  }

}
