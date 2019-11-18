package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Triangle_120 {

  public int minimumTotal(List<List<Integer>> triangle) {

    int currentMin = Integer.MAX_VALUE;

    int[] dp = new int[triangle.get(triangle.size() - 1).size()];

    List<Integer> lastRow = triangle.get(triangle.size() - 1);

    for (int i = 0; i < dp.length; i++) {
      dp[i] = lastRow.get(i);
    }

    for (int j = triangle.size() - 2; j > -1; j--) {
      lastRow = triangle.get(j);

      for (int i = 0; i < lastRow.size(); i++) {
        dp[i] = lastRow.get(i) + Math.min(dp[i], dp[i + 1]);
        if (i > 0) {
          currentMin = Math.min(dp[i], dp[i - 1]);
        } else {
          currentMin = dp[i];
        }
      }


    }

    return currentMin == Integer.MAX_VALUE ? triangle.get(0).get(0) : currentMin;

  }


  @Test
  public void test1() {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(minimumTotal(triangle));
  }


  @Test
  public void test2() {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(-1));
    triangle.add(Arrays.asList(3, 2));
    triangle.add(Arrays.asList(-3, 1, -1));
    //triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(minimumTotal(triangle));
  }

  @Test
  public void test3() {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(-10));
    //triangle.add(Arrays.asList(3, 2));
    //triangle.add(Arrays.asList(-3,1,-1));
    //triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(minimumTotal(triangle));
  }

}
