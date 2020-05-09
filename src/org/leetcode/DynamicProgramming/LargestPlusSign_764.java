package org.leetcode.DynamicProgramming;


import java.util.Arrays;
import org.junit.Test;

public class LargestPlusSign_764 {


  public int orderOfLargestPlusSign(int N, int[][] mines) {
    int res = 0;

    int[][] dp = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], N);
    }

    for (int[] mine : mines) {
      dp[mine[0]][mine[1]] = 0;
    }

    //left and right

    for (int i = 0; i < N; i++) {
      int left = 0;

      for (int j = 0; j < N; j++) {
        left = dp[i][j] == 0 ? 0 : left + 1;
        dp[i][j] = Math.min(dp[i][j], left);
      }

      int right = 0;

      for (int j = N - 1; j > -1; j--) {
        right = dp[i][j] == 0 ? 0 : right + 1;
        dp[i][j] = Math.min(dp[i][j], right);

      }
    }

    //up and down

    for (int j = 0; j < N; j++) {
      int down = 0;

      for (int i = 0; i < N; i++) {
        down = dp[i][j] == 0 ? 0 : down+1;
        dp[i][j] = Math.min(dp[i][j], down);
      }

      int up = 0;

      for (int i = N - 1; i > -1; i--) {
        up = dp[i][j] == 0 ? 0 : up+1;
        dp[i][j] = Math.min(dp[i][j], up);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        res = Math.max(res, dp[i][j]);
      }
    }

    return res;
  }

  @Test
  public void test() {
    int[][] mines = {};

    System.out.println(orderOfLargestPlusSign(7, mines));
  }


  @Test
  public void test2() {
    int[][] mines = {{0, 0}, {0, 1}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {2, 3},
        {2, 4}, {3, 0}, {4, 0}, {4, 1}, {4, 3}, {4, 4}};
    System.out.println(orderOfLargestPlusSign(5, mines));
  }


}
