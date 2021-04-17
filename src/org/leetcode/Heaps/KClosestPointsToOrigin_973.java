package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KClosestPointsToOrigin_973 {

  public int[][] kClosest(int[][] points, int K) {
    int[][] closest = new int[K][2];

    PriorityQueue<Coordinates> minHeap = new PriorityQueue<>((o1, o2) -> {
      if (Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2)) > Math
          .sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2))) {
        return -1;
      } else {
        return 1;
      }
    });

    for (int i = 0; i < points.length; i++) {
      minHeap.add(new Coordinates(points[i][0], points[i][1]));
    }

    for (int i = 0; i < K; i++) {
      Coordinates coordinates = minHeap.poll();
      closest[i][0] = coordinates.x;
      closest[i][1] = coordinates.y;
    }
    return closest;
  }

  public class Coordinates {

    int x;
    int y;

    public Coordinates(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  @Test
  public void testClosest1() {
    int[][] points = {{1, 3}, {-2, 2}};
    kClosest(points, 1);
  }

  @Test
  public void testClosest2() {
    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    kClosest(points, 2);
  }

}
