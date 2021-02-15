package org.nithishgvs.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class JohnDeere2 {

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int maxValue = 0;

    int[][] dp = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          if (i >= 1 && j >= 1) {
            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
          } else {
            dp[i][j] = 1;
          }
          maxValue = Math.max(maxValue, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return maxValue * maxValue;
  }

  public static int largestArea(List<List<Integer>> samples) {
    if (samples.size() == 0) {
      return 0;
    }

    int maxValue = 0;

    int[][] dp = new int[samples.size()][samples.get(0).size()];

    for (int i = 0; i < samples.size(); i++) {
      for (int j = 0; j < samples.get(i).size(); j++) {
        if (samples.get(i).get(j) == 1) {
          if (i >= 1 && j >= 1) {
            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
          } else {
            dp[i][j] = 1;
          }
          maxValue = Math.max(maxValue, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return maxValue;
  }


  @Test
  public void test1() {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(1);
    list1.add(1);
    list1.add(1);
    list1.add(1);
    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(1);
    list2.add(1);
    list2.add(0);
    list2.add(0);
    List<Integer> list3 = new ArrayList<>();
    list3.add(1);
    list3.add(1);
    list3.add(1);
    list3.add(0);
    list3.add(0);
    List<Integer> list4 = new ArrayList<>();
    list4.add(1);
    list4.add(1);
    list4.add(1);
    list4.add(0);
    list4.add(0);
    List<Integer> list5 = new ArrayList<>();
    list5.add(1);
    list5.add(1);
    list5.add(1);
    list5.add(1);
    list5.add(1);
    List<List<Integer>> samples = new ArrayList<>();
    samples.add(list1);
    samples.add(list2);
    samples.add(list3);
    samples.add(list4);
    samples.add(list5);
    System.out.println(largestArea(samples));
    Map<String,List<Map<String,String>>> map=new HashMap<>();
    map.forEach((k,v)-> System.out.println(k+" "+v));
  }
}
