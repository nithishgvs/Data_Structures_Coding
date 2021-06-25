package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class TwoCityScheduling_1029 {


  public int twoCitySchedCost(int[][] costs) {

    int minCost = 0;

    PriorityQueue<Profit> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);

    for (int[] cost : costs) {
      priorityQueue.add(new Profit(cost, cost[1] - cost[0]));
    }

    for (int i = 0; i < costs.length; i++) {
      if (i < costs.length / 2) {
        minCost += priorityQueue.poll().cost[0];
      } else {
        minCost += priorityQueue.poll().cost[1];
      }

    }

    return minCost;

  }

  class Profit {

    int[] cost;
    int profit;

    public Profit(int[] cost, int profit) {
      this.cost = cost;
      this.profit = profit;
    }
  }

  @Test
  public void test() {
    int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
    System.out.println(twoCitySchedCost(costs));
  }

  @Test
  public void test1() {
    int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
    System.out.println(twoCitySchedCost(costs));
  }
}
