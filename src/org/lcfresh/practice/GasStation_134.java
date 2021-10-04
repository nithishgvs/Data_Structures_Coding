package org.lcfresh.practice;

import java.util.Arrays;
import org.junit.Test;

/**
 * Back to back watch it next
 */
public class GasStation_134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
      return -1;
    }

    int station = 0;
    int tank = 0;

    for (int currStation = 0; currStation < gas.length; currStation++) {
      tank += gas[currStation] - cost[currStation];
      if (tank < 0) {
        tank = 0;
        station = currStation + 1;
      }
    }

    return station;
  }


  @Test
  public void test1() {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(gas, cost));
  }

}
