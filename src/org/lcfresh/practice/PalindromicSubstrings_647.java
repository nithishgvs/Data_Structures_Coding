package org.lcfresh.practice;

import org.junit.Test;

public class PalindromicSubstrings_647 {


  public int countSubstrings(String s) {

    int count = 0;

    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {
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
            if (dp[i + 1][j - 1] > 0) {
              dp[i][j] = 1;
              count++;
            } else if (i + 1 > j - 1) {
              dp[i][j] = 1;
              count++;
            }

          }
        }
        i++;
      }
      l = l + 1;
    }
    return count;

  }

  @Test
  public void test1() {
    System.out.println(countSubstrings("abc"));
  }


}
