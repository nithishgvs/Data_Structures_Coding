package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import org.junit.Test;

public class TaskScheduler_621 {

  public int leastInterval(char[] tasks, int n) {
    int leastInterval = 0;

    Map<Character, Integer> taskMap = new HashMap<>();

    for (char ch : tasks) {
      taskMap.put(ch, taskMap.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    maxHeap.addAll(taskMap.entrySet());

    while (!maxHeap.isEmpty()) {

      int i;

      List<Map.Entry<Character, Integer>> list = new ArrayList<>();

      for (i = n + 1; i > 0 && !maxHeap.isEmpty(); i--) {
        leastInterval++;

        Map.Entry<Character, Integer> entry = maxHeap.poll();
        if (entry.getValue() > 1) {
          entry.setValue(entry.getValue() - 1);
          list.add(entry);
        }
      }

      maxHeap.addAll(list);
      if (!maxHeap.isEmpty()) {
        leastInterval += i;
      }

    }

    return leastInterval;
  }

  @Test
  public void testTaskScheduler1() {

    System.out.println(leastInterval("AAAABBBEEFFGG".toCharArray(), 3));
  }

  @Test
  public void testTaskScheduler2() {

    System.out.println(leastInterval("ACCCEEE".toCharArray(), 2));
  }

  @Test
  public void testTaskScheduler3() {

    System.out.println(leastInterval("AAABBB".toCharArray(), 2));
  }

  @Test
  public void testTaskScheduler4() {

    System.out.println(leastInterval("ABCDEABCDE".toCharArray(), 4));
  }


}
