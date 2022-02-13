package org.twentytwentytwo.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class ReorganizeString_767 {

  public String reorganizeString(String s) {

    StringBuilder stringBuilder = new StringBuilder();

    Map<Character, Integer> helperMap = new HashMap<>();
    for (char ch : s.toCharArray()) {
      Integer freq = helperMap.getOrDefault(ch, 0);
      helperMap.put(ch, freq + 1);
    }
    PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
    maxHeap.addAll(helperMap.entrySet());

    Queue<Map.Entry<Character, Integer>> queue = new ArrayDeque<>();

    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> polled = maxHeap.poll();
      stringBuilder.append(polled.getKey());
      queue.add(polled);
      while (queue.size() > 1) {
        Map.Entry<Character, Integer> dequeue = queue.poll();
        if (dequeue.getValue() > 1) {
          dequeue.setValue(dequeue.getValue() - 1);
          maxHeap.add(dequeue);
        }
      }

    }

    return stringBuilder.length() == s.length() ? stringBuilder.toString() : "";
  }


  @Test
  public void test1() {
    System.out.println(reorganizeString("aaab"));
  }

}
