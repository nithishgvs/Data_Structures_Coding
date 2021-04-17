package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class MinimumCosttoConnectSticks_1167 {

  public int connectSticks(int[] sticks) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int cost = 0;

    for (int stick : sticks) {
      priorityQueue.add(stick);
    }

    while (priorityQueue.size() > 1) {
      int first = priorityQueue.poll();
      int second = priorityQueue.poll();
      cost = cost + first + second;
      priorityQueue.add(first+second);

    }

    return cost;

  }


  @Test
  public void test() {
    System.out.println(connectSticks(new int[]{4,6,8}));
  }


}
