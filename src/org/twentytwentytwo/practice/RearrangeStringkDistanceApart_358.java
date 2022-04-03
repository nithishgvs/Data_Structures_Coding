package org.twentytwentytwo.practice;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class RearrangeStringkDistanceApart_358 {

  public String rearrangeString(String s, int k) {

    if (k == 0) {
      return s;
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (o1, o2) -> o2.getValue() - o1.getValue());

    StringBuilder sb = new StringBuilder();

    Map<Character, Integer> map = new LinkedHashMap<>();

    for (char ch : s.toCharArray()) {
      if (!map.containsKey(ch)) {
        map.put(ch, 0);
      }
      Integer val = map.get(ch);
      map.put(ch, ++val);
    }
    maxHeap.addAll(map.entrySet());
    Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> polled = maxHeap.poll();
      sb.append(polled.getKey());
      polled.setValue(polled.getValue() - 1);
      queue.add(polled);
      while (queue.size() >= k) {
        Map.Entry<Character, Integer> dequeue = queue.poll();
        if (dequeue.getValue() > 0) {
          maxHeap.offer(dequeue);
        }
      }

    }

    return sb.length() == s.length() ? sb.toString() : "";

  }


  @Test
  public void test() {
    System.out.println(rearrangeString("aabbcc", 3));

  }

}
