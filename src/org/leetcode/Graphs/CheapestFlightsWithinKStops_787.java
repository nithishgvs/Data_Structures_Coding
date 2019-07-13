package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class CheapestFlightsWithinKStops_787 {

  public class FlightHelper {

    int source;
    int destination;
    int cost;

    public FlightHelper(int source, int destination, int cost) {
      this.source = source;
      this.destination = destination;
      this.cost = cost;
    }
  }


  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

    //Map has key source and value with array (index0-> destination,index1->cost)

    Map<Integer, List<int[]>> map = new HashMap<>();

    for (int[] arr : flights) {
      if (map.containsKey(arr[0])) {
        List<int[]> currList = map.get(arr[0]);
        currList.add(new int[]{arr[1], arr[2]});
      } else {
        List<int[]> currList = new ArrayList<>();
        currList.add(new int[]{arr[1], arr[2]});
        map.put(arr[0], currList);
      }
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    priorityQueue.add(new int[]{src, 0, 0});

    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      if (current[0] == dst) {
        return current[1];
      }

      if (current[2] > K || !map.containsKey(current[0])) {
        continue;
      }

      if (map.get(current[0]) != null) {
        for (int[] arr : map.get(current[0])) {
          priorityQueue.add(new int[]{arr[0], current[1] + arr[1], current[2] + 1});
        }
      }
    }

    return -1;
  }


  @Test
  public void test1() {
    System.out
        .println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
  }

  @Test
  public void test2() {
    findCheapestPrice(5,
        new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1);
  }

  @Test
  public void test3() {
    System.out
        .println(findCheapestPrice(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}}, 1, 2, 1));
  }

  @Test
  public void test4() {
    System.out
        .println(findCheapestPrice(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}}, 1, 2, 1));
  }
}
