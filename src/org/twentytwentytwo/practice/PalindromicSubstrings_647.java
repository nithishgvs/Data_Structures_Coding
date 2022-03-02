package org.twentytwentytwo.practice;

import org.junit.Test;

public class PalindromicSubstrings_647 {

  public int countSubstrings(String s) {
    int count = 0;

    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = 1;
      count++;
    }

    int l = 1;
    while (l < dp.length) {
      int i = 0;
      while (i < dp.length) {
        int j = i + l;
        if (j < dp.length) {
          if (s.charAt(i) == s.charAt(j)) {
            if (j - i == 1) {
              dp[i][j] = 2;
              count++;
            } else if (dp[i + 1][j - 1] != 0) {
              dp[i][j] = dp[i + 1][j - 1] + 2;
              count++;
            }
          }
        }
        i++;
      }
      l++;
    }
    return count;
  }


  @Test
  public void test() {
    System.out.println(countSubstrings("aaa"));
  }

}
