package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class TopKFrequentElements_347 {

  public List<Integer> topKFrequent(int[] nums, int k) {

    List<Integer> outList = new ArrayList<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (freqMap.containsKey(nums[i])) {
        freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
      } else {
        freqMap.put(nums[i], 1);
      }
    }

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue() - o1.getValue();
      }
    });

    int i = 0;
    while (i < k) {
      outList.add(list.get(i).getKey());
      i++;
    }

    return outList;
  }


  @Test
  public void testFreqElements() {
    int[] nums = {1, 1, 1, 2, 2, 3};
    topKFrequent(nums, 2).forEach(System.out::println);
  }


}
