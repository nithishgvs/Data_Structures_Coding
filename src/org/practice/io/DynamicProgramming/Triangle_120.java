package org.practice.io.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Triangle_120 {


  public int minimumTotal(List<List<Integer>> triangle) {
    int lastIndex = triangle.size() - 1;
    int[] dp = new int[triangle.get(lastIndex).size()];
    for (int i = 0; i < triangle.get(lastIndex).size(); i++) {
      dp[i] = triangle.get(lastIndex).get(i);
    }

    for (int i = lastIndex - 1; i > -1; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int current = triangle.get(i).get(j);
        dp[j] = Math.min(dp[j], dp[j + 1]) + current;
      }
    }

    return dp[0];

  }


  @Test
  public void test1() {
    //[[2],[3,4],[6,5,7],[4,1,8,3]]
    List<Integer> list1 = Arrays.asList(2);
    List<Integer> list2 = Arrays.asList(3, 4);
    List<Integer> list3 = Arrays.asList(6, 5, 7);
    List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
    minimumTotal(Arrays.asList(list1, list2, list3, list4));

  }

}
