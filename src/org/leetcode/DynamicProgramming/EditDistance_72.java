package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class EditDistance_72 {


  public int minDistance(String word1, String word2) {
    int[][] matrix = new int[word2.length() + 1][word1.length() + 1];

    for (int i = 0; i < matrix[0].length; i++) {
      matrix[0][i] = i;
    }

    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = i;
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1];
        } else {
          matrix[i][j] =
              Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
        }
      }
    }

    return matrix[word2.length()][word1.length()];
  }


  @Test
  public void test1() {
    System.out.println(minDistance("abcfg", "adceg"));
  }

  @Test
  public void test2() {
    System.out.println(minDistance("horse", "ros"));
  }


  @Test
  public void test3() {
    System.out.println(minDistance("sea", "eat"));
  }
}
