package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class CheapestFlightsWithinKStops_787 {


  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    Map<Integer, List<int[]>> helperMap = new HashMap<>();

    int[] minDist = new int[n];

    Arrays.fill(minDist, Integer.MAX_VALUE);

    for (int[] flight : flights) {
      List<int[]> neighbour = helperMap.getOrDefault(flight[0], new ArrayList<>());
      neighbour.add(new int[]{flight[1], flight[2]});
      helperMap.put(flight[0], neighbour);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[2]));

    minHeap.add(new int[]{src, 0, 0});
    while (!minHeap.isEmpty()) {
      int size = minHeap.size();
      for (int i = 0; i < size; i++) {
        int[] polled = minHeap.poll();
        int currSrc = polled[0];
        int currDist = polled[1];
        int currLevel = polled[2];
        if (currLevel > k) {
          break;
        }
        for (int[] neighbour : helperMap.getOrDefault(currSrc, new ArrayList<>())) {
          if (currDist + neighbour[1] < minDist[neighbour[0]]) {
            minDist[neighbour[0]] = currDist + neighbour[1];
            minHeap.add(new int[]{neighbour[0], minDist[neighbour[0]], currLevel + 1});
          }
        }
      }
    }

    return minDist[dst] == Integer.MAX_VALUE ? -1 : minDist[dst];

  }

  @Test
  public void test1() {
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    System.out.println(findCheapestPrice(3, flights, 0, 2, 1));

  }

}
