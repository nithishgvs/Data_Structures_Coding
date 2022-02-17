package org.twentytwentytwo.practice;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

  public int[][] kClosest(int[][] points, int K) {
    int[][] closest = new int[K][2];

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
      if (Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2)) > Math
          .sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2))) {
        return -1;
      } else {
        return 1;
      }
    });

    for (int i = 0; i < points.length; i++) {
      minHeap.add(points[i]);
    }

    for (int i = 0; i < K; i++) {
      int[] coordinates = minHeap.poll();
      closest[i][0] = coordinates[0];
      closest[i][1] = coordinates[1];
    }
    return closest;
  }
}
