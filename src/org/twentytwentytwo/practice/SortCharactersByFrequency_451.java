package org.twentytwentytwo.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class SortCharactersByFrequency_451 {


  public String frequencySort(String s) {

    StringBuilder sb = new StringBuilder();

    Map<Character, Integer> map = new HashMap<>();

    for (Character character : s.toCharArray()) {
      int value = map.getOrDefault(character, 0);
      map.put(character, value + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    maxHeap.addAll(map.entrySet());

    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> polled = maxHeap.poll();
      sb.append(
          String.join("", Collections.nCopies(polled.getValue(), polled.getKey().toString())));
    }

    return sb.toString();

  }

  @Test
  public void test(){
    frequencySort("Aabb");
  }

}
