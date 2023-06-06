package org.practice.io.DynamicProgramming;

import org.junit.Test;

public class LongestPalindromicSubstring_5 {

  public String longestPalindrome(String s) {

    int[][] dp = new int[s.length()][s.length()];

    int maxRow = 0;
    int maxColumn = 0;

    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
      maxRow = i;
      maxColumn = i;
    }

    int maxLength = 1;

    int k = 1;

    while (k < s.length()) {
      int i = 0;
      int j = k;
      while (j < s.length()) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i == 1) {
            dp[i][j] = 2;
            if (dp[i][j] > maxLength) {
              maxRow = i;
              maxColumn = j;
              maxLength = dp[i][j];
            }
          } else if (dp[i + 1][j - 1] > 0) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
            if (dp[i][j] > maxLength) {
              maxRow = i;
              maxColumn = j;
              maxLength = dp[i][j];
            }
          }
        }
        i++;
        j++;
      }
      k++;
    }

    char[] resultArray = new char[maxLength];

    int i = maxRow;
    int j = maxColumn;

    int m = 0;
    int n = maxLength - 1;

    while (i <= j) {
      if (s.charAt(i) == s.charAt(j)) {
        resultArray[m] = s.charAt(i);
        resultArray[n] = s.charAt(j);
      } else {
        break;
      }
      m++;
      n--;
      i++;
      j--;
    }

    return String.valueOf(resultArray);

  }

  @Test
  public void test1() {
    //countSubstrings("adadp");
    longestPalindrome("adadp");
    //countSubstrings("adadp");
  }
}
