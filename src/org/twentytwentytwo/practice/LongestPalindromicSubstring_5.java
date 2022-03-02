package org.twentytwentytwo.practice;

import org.junit.Test;

public class LongestPalindromicSubstring_5 {


  public String longestPalindrome(String s) {

    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = 1;
    }

    int l = 1;
    int maxY = 0;
    int maxX = 0;

    int max = 1;

    while (l < dp.length) {
      int i = 0;
      while (i < dp.length) {
        int j = i + l;
        if (j < dp.length) {
          if (s.charAt(i) == s.charAt(j)) {
            if (j - i == 1) {
              dp[i][j] = 2;
            } else if (dp[i + 1][j - 1] != 0) {
              dp[i][j] = dp[i + 1][j - 1] + 2;
            }
            if (dp[i][j] >= max) {
              maxY = j;
              maxX = i;
              max = dp[i][j];
            }
          } else {
            dp[i][j] = 0;
          }
        }
        i++;
      }
      l++;
    }

    int endIndex = maxY;

    int startIndex = maxX;

    int i = startIndex;
    int j = endIndex;

    while (i < dp.length && j > -1) {
      if (s.charAt(i) == s.charAt(j)) {
        startIndex = j;
        i = i + 1;
        j = j - 1;
      } else {
        break;
      }
    }

    return s.substring(startIndex, endIndex + 1);

  }

  @Test
  public void test1() {
    System.out.println(longestPalindrome("aacabdkacaa"));
  }

}
