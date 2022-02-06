package org.seanparshad.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class TaskScheduler_621 {


  public int leastInterval(char[] tasks, int n) {

    Map<Character, Integer> helperMap = new HashMap<>();
    StringBuilder intervalBuilder = new StringBuilder();

    for (char ch : tasks) {
      Integer freq = helperMap.getOrDefault(ch, 0);
      helperMap.put(ch, freq + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
    maxHeap.addAll(helperMap.entrySet());

    Queue<Entry<Character, Integer>> queue = new ArrayDeque<>();

    while (!maxHeap.isEmpty()) {
      for (int i = 0; i < n + 1; i++) {
        Character value = maxHeap.isEmpty() ? '\0' : maxHeap.peek().getKey();
        if (value == '\0') {
          intervalBuilder.append(" ");
        } else {
          intervalBuilder.append(value);
          queue.add(maxHeap.poll());
        }
      }
      while (!queue.isEmpty()) {
        Map.Entry<Character, Integer> polled = queue.poll();
        if (polled.getValue() > 1) {
          polled.setValue(polled.getValue()-1);
          maxHeap.add(polled);
        }
      }
    }

    return intervalBuilder.toString().trim().length();
  }


  @Test
  public void test1() {
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    System.out.println(leastInterval(tasks, 50));
  }


}
