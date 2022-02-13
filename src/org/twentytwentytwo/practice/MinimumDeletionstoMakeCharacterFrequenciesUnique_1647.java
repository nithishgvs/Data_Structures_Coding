package org.twentytwentytwo.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 {


  public int minDeletions(String s) {
    int minDeletions = 0;

    Map<Character, Integer> helperMap = new HashMap<>();

    for (char ch : s.toCharArray()) {
      int value = helperMap.getOrDefault(ch, 0);
      helperMap.put(ch, value + 1);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    minHeap.addAll(helperMap.values());

    while (!minHeap.isEmpty()) {
      int polled = minHeap.poll();
      if (minHeap.contains(polled)) {
        polled = polled-1;
        minDeletions++;
        if (polled != 0) {
          minHeap.add(polled);
        }
      }
    }

    return minDeletions;
  }

  @Test
  public void test() {
    System.out.println(minDeletions("ceabaacb"));
    System.out.println(minDeletions("aaabbbcc"));
    System.out.println(minDeletions("aab"));
  }
}
