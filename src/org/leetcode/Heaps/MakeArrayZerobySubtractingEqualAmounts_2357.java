package org.leetcode.Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class MakeArrayZerobySubtractingEqualAmounts_2357 {


  public int minimumOperations1(int[] nums) {
    int min = 0;

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    for (int n : nums) {
      if (n != 0) {
        priorityQueue.add(n);
      }
    }

    if (priorityQueue.isEmpty()) {
      return min;
    }

    List<Integer> list = new ArrayList<>();

    int minimum = priorityQueue.peek();

    while (!priorityQueue.isEmpty()) {
      int newValue = priorityQueue.poll() - minimum;
      if (newValue > 0) {
        list.add(newValue);
      }
      if (priorityQueue.size() == 0) {
        priorityQueue.addAll(list);
        list.clear();
        min++;
        if (!priorityQueue.isEmpty()) {
          minimum = priorityQueue.peek();
        }
      }
    }

    return min;

  }

  public int minimumOperations(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int n : nums) {
      if (n != 0) {
        map.put(n, 0);
      }
    }

    return map.size();

  }


  @Test
  public void test() {
    System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
  }


}
