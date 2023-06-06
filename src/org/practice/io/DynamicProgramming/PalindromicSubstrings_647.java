package org.practice.io.DynamicProgramming;

import org.junit.Test;

public class PalindromicSubstrings_647 {


  public int countSubstrings(String s) {
    int[][] dp = new int[s.length()][s.length()];

    int palindromeSubstrings = 0;

    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
      palindromeSubstrings++;
    }

    int k = 1;

    while (k < s.length()) {
      int i = 0;
      int j = k;
      while (j < s.length()) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i == 1) {
            dp[i][j] = 2;
            palindromeSubstrings++;
          } else if (dp[i + 1][j - 1] > 0) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
            palindromeSubstrings++;
          }
        }
        i++;
        j++;
      }
      k++;
    }
    return palindromeSubstrings;

  }


  @Test
  public void test1() {
    //countSubstrings("adadp");
    countSubstrings("madam");
    //countSubstrings("adadp");
  }

}
