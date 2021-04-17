package org.leetcode.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CinemaSeatAllocation_1386 {

  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    int max = n * 2;

    Map<Integer, List<Integer>> helperMap = new HashMap<>();

    for (int i = 0; i < reservedSeats.length; i++) {
      if (!helperMap.containsKey(reservedSeats[i][0])) {
        helperMap.put(reservedSeats[i][0], new ArrayList<>());
      }
      helperMap.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
    }

    for (Map.Entry<Integer, List<Integer>> entry : helperMap.entrySet()) {
      List<Integer> entries = entry.getValue();
      int misses = 0;
      if (entries.contains(2) || entries.contains(3) || entries.contains(4) || entries
          .contains(5)) {
        max--;
        misses++;
      }
      if (entries.contains(6) || entries.contains(7) || entries.contains(8) || entries
          .contains(9)) {
        max--;
        misses++;
      }

      if (!entries.contains(4) && !entries.contains(5) && !entries.contains(6) && !entries
          .contains(7)) {
        if (misses == 2) {
          max++;
        }
      }


    }

    return max;

  }


  @Test
  public void test1() {
    int[][] reserved = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
    System.out.println(maxNumberOfFamilies(3, reserved));
  }

}
