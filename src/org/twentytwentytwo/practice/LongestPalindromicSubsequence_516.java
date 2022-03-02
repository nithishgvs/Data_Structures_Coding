package org.twentytwentytwo.practice;

public class LongestPalindromicSubsequence_516 {

  public int longestPalindromeSubseq(String s) {
    int max = -1;

    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
      max = Math.max(max, dp[i][i]);
    }

    int l = 1;
    while (l < dp.length) {
      int i = 0;
      while (i < dp.length) {
        int j = i + l;
        if (j < dp.length) {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dp[i + 1][j - 1] + 2;
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
          }
          max = Math.max(max, dp[i][j]);
        }
        i++;
      }
      l = l + 1;
    }

    return max;
  }

}
