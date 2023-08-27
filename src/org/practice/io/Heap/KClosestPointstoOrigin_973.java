package org.practice.io.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Test;

public class KClosestPointstoOrigin_973 {

  public int[][] kClosest(int[][] points, int k) {

    int[][] closest = new int[k][2];

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      double value1 = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
      double value2 = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));
      if (value1 > value2) {
        return 1;
      }
      return -1;
    });

    Arrays.stream(points).forEach(entry -> priorityQueue.add(entry));

    int count = 0;

    while (!priorityQueue.isEmpty() && count < k) {
      closest[count][0] = priorityQueue.peek()[0];
      closest[count][1] = priorityQueue.peek()[1];
      priorityQueue.poll();
      count++;
    }

    return closest;

  }


  @Test
  public void test() {
    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    int[][] points1 = {{1, 3}, {-2,2}};
    System.out.println(kClosest(points1, 1));
  }

}
