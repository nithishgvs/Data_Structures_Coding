package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class LastStoneWeight_1046 {

  public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
        (a, b) -> b.intValue() - a.intValue());

    for (int i = 0; i < stones.length; i++) {
      priorityQueue.add(stones[i]);
    }

    while (priorityQueue.size() > 1) {
      int y = priorityQueue.poll();
      int x = priorityQueue.poll();
      if (y == x) {
        continue;
      } else {
        priorityQueue.add(y - x);
      }
    }

    return priorityQueue.isEmpty()?0:priorityQueue.poll();

  }


  @Test
  public void test() {
    int[] stones = new int[]{2, 7, 4, 1, 8, 1};
    System.out.println(lastStoneWeight(stones));

  }

}
