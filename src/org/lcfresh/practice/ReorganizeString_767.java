package org.lcfresh.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class ReorganizeString_767 {

  public String reorganizeString(String s) {

    StringBuilder result = new StringBuilder();

    PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
        (o1, o2) -> o2.getValue().compareTo(o1.getValue())
    );

    Map<Character, Integer> map = new HashMap<>();

    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    priorityQueue.addAll(map.entrySet());

    Queue<Entry<Character, Integer>> queue = new LinkedList<>();

    while (!priorityQueue.isEmpty()) {
      Map.Entry<Character, Integer> entry = priorityQueue.poll();
      result.append(entry.getKey());
      entry.setValue(entry.getValue() - 1);
      queue.add(entry);
      while (queue.size() > 1) {
        Map.Entry<Character, Integer> polled = queue.poll();
        if (polled.getValue() > 0) {
          priorityQueue.add(polled);
        }
      }
    }

    return result.length() == s.length() ? result.toString() : "";

  }

  @Test
  public void test() {
    String S = "baaba";
    String S2 = "aaab";
    System.out.println(reorganizeString(S2));
  }

}
